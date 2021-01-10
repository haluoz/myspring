package org.myspring.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myspring.core.annotation.Component;
import org.myspring.core.annotation.Controller;
import org.myspring.core.annotation.Repository;
import org.myspring.core.annotation.Service;
import org.myspring.core.aop.annotation.Aspect;
import org.myspring.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lee
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {
    /**
     * 存放所有被标记的目标对象的Map
     * @Controller
     * @Service
     * @Repository
     * @Component
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<Class<?>, Object>();

    private boolean loaded = false;


    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Controller.class, Service.class, Repository.class, Component.class, Aspect.class);
    /**
     * 获取Bean容器实例
     * @return
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.beanContainer;
    }

    /**
     * 扫描加载所有的bean
     * @param packageName
     */
    public synchronized void loadBeans(String packageName){
        //判断bean容器是非被加载过
        if (isLoaded()){
            log.warn("bean container has been loaded");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extraPackageClass(packageName);
        if (classSet == null || classSet.isEmpty()){
            log.warn("nothing can be extract from package");
            return;
        }
        for (Class<?> clazz: classSet) {
            for (Class<? extends Annotation> annotation: BEAN_ANNOTATION){
                //如果类上标记了定义的注解
                if (clazz.isAnnotationPresent(annotation)){
                    //讲目标类本身作为key，目标类的实例作为值放入beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 添加一个class对象和bean实例
     * @param clazz class对象
     * @param bean bean实例
     * @return 原有bean实例,没有则返回null
     */
    public Object addBean(Class<?> clazz, Object bean){
        return beanMap.put(clazz,bean);
    }

    /**
     * 删除IOC容器的对象
     * @param clazz class对象
     * @return 删除bean实例,没有则返回null
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }

    /**
     * 获取单个bean实例
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz){
        return beanMap.get(clazz);
    }

    /**
     * 获取容器所有class对象集合
     * @return
     */
    public Set<Class<?>> getClasses(){
        return beanMap.keySet();
    }

    /**
     * 获取所有bean集合
     * @return
     */
    public Set<Object> getBeans(){
        return new HashSet<>(beanMap.values());
    }

    /**
     * 根据注解筛选出bean的class集合
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation){
        //1.获取beanMap的所有对象
        Set<Class<?>> keySet = getClasses();
        if (keySet == null ||keySet.isEmpty()){
            log.warn("nothing in beanMap");
            return null;
        }
        //2.通过注解筛选被注解标记的class对象并添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz: keySet) {
            if (clazz.isAnnotationPresent(annotation)){
                classSet.add(clazz);
            }
        }
        return classSet.size()>0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的class集合，不包括本身
     * @param interfaceOrClass
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass){
        //1.获取beanMap的所有对象
        Set<Class<?>> keySet = getClasses();
        if (keySet == null ||keySet.isEmpty()){
            log.warn("nothing in beanMap");
            return null;
        }
        //2.判断keySet里的元素是否是传入的接口或者类的子类，如果是就添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz: keySet) {
            if (interfaceOrClass.isAssignableFrom(clazz)){
                classSet.add(clazz);
            }
        }
        return classSet.size()>0 ? classSet : null;
    }

    public int beanMapSize(){
        return beanMap.size();
    }

    public boolean isLoaded(){
        return this.loaded;
    }

    private enum ContainerHolder{
        HOLDER;
        private BeanContainer beanContainer;
        ContainerHolder(){
            beanContainer = new BeanContainer();
        }
    }
}
