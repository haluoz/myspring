package org.myspring.core.aop;

import org.myspring.core.BeanContainer;
import org.myspring.core.aop.annotation.Aspect;
import org.myspring.core.aop.annotation.Order;
import org.myspring.core.aop.aspect.AspectInfo;
import org.myspring.core.aop.aspect.DefaultAspect;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AspectWeaver {
    private BeanContainer beanContainer;

    public AspectWeaver() {
        this.beanContainer = BeanContainer.getInstance();
    }

    public void doAop(){
        //1.获取所有的切面类
        Set<Class<?>> aspectSet = beanContainer.getClassesByAnnotation(Aspect.class);
        //2.将切面类按照不同的织入目标进行切分

        HashMap<Class<? extends Annotation>, List<AspectInfo>> map = new HashMap<>();
        if (aspectSet == null || aspectSet.isEmpty()){
            return;
        }
        for (Class<?> aspectClass :aspectSet) {
            if(verifyAspect(aspectClass)){
                categorizedAspect(map, aspectClass);
            }else {
                throw new RuntimeException("@Aspect and @Order have not been added to the aspect class" +
                        "or Aspect class does not extend from DefaultAspect, or the value in Aspect Tag equals to @Aspect");
            }
        }
        //3.按照不同的织入目标分别去按顺序织入Aspect逻辑
        if (map == null || map.isEmpty()){
            return;
        }
        for (Class<? extends Annotation> category: map.keySet()) {
            weaveByCategory(category,map.get(category));
        }
    }

    private void weaveByCategory(Class<? extends Annotation> category, List<AspectInfo> aspectInfos) {
        //1.获取被代理类的集合
        Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(category);
        if (classSet ==null || classSet.isEmpty()){
            return;
        }
        //2.便利被代理类，分别为每个代理类生成动态代理实例
        for(Class<?> targetClass: classSet){
            AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass,aspectInfos);
            Object proxyBean = ProxyCreator.createProxy(targetClass, aspectListExecutor);
            beanContainer.addBean(targetClass, proxyBean);
        }
        //3.将动态代理对象实例添加到容器里，取代未被代理前的类实例

    }

    private void categorizedAspect(HashMap<Class<? extends Annotation>, List<AspectInfo>> map, Class<?> aspectClass) {
        Order orderAnnotation = aspectClass.getAnnotation(Order.class);
        Aspect aspectAnnotation = aspectClass.getAnnotation(Aspect.class);
        DefaultAspect aspect = (DefaultAspect) beanContainer.getBean(aspectClass);
        AspectInfo aspectInfo = new AspectInfo(orderAnnotation.value(), aspect);
        if (!map.containsKey(aspectAnnotation.value())){
            //如果织入的joinpoint第一次出现，以新创建的List<AspectInfo>为value
            ArrayList<AspectInfo> aspectInfos = new ArrayList<>();
            aspectInfos.add(aspectInfo);
            map.put(aspectAnnotation.value(), aspectInfos);
        }else {
            //如果织入的joinpoint不是第一次出现，则往joinpoint对应的value里添加新的Aspect逻辑
            List<AspectInfo> aspectInfos = map.get(aspectAnnotation.value());
            aspectInfos.add(aspectInfo);

        }
    }

    /**
     * 框架中一点要遵循给Aspect类添加@Aspect和@Order标签的规范
     * 同时, 必须继承DefaultAspect.class
     * 此外, @Aspect的属性值不能是它本身
     * @param aspectClass
     * @return
     */
    private boolean verifyAspect(Class<?> aspectClass) {
        return aspectClass.isAnnotationPresent(Aspect.class)
                && aspectClass.isAnnotationPresent(Order.class)
                && DefaultAspect.class.isAssignableFrom(aspectClass)
                && aspectClass.getAnnotation(Aspect.class).value() != Aspect.class;
    }
}
