package org.myspring.core.inject;

import lombok.extern.slf4j.Slf4j;
import org.myspring.core.BeanContainer;
import org.myspring.core.inject.annotation.Autowired;
import org.myspring.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author lee
 */
@Slf4j
public class DependencyInjector {
    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    public DependencyInjector(){
        beanContainer = BeanContainer.getInstance();
    }

    /**
     *
      */
    public void doIoc(){
        //1.遍历Bean容器中的所有Class对象
        Set<Class<?>> classes = beanContainer.getClasses();
        if (classes == null || classes.isEmpty()){
            log.warn("empty classSet in bean container");
            return;
        }
        for (Class<?> clazz :classes) {
            //2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (fields == null){
                continue;
            }
            for (Field f:fields) {
                //3.找出Autowired标记的成员变量
                if (f.isAnnotationPresent(Autowired.class)){
                    Autowired autowired = f.getAnnotation(Autowired.class);
                    String value = autowired.value();
                    //4.获得这些成员变量的类型
                    Class<?> fieldClass = f.getType();
                    //5.获得这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass, value);
                    if (fieldValue == null){
                        throw new RuntimeException("unable to inject relevant type, target field is:"+fieldClass.getName() + value);
                    }else {
                        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(f, targetBean,fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据class在beanContainer里获取其实例或实现类
     * @param fieldClass
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass,String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null){
            return fieldValue;
        }else {
            Class<?> implementClass = getImplementClass(fieldClass,autowiredValue);
            if (implementClass != null){
                return beanContainer.getBean(implementClass);
            }else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     * @param fieldClass
     * @param autowiredValue
     * @return
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (classSet != null || !classSet.isEmpty()){
            if (autowiredValue == null || "".equals(autowiredValue)){
                if (classSet.size() == 1){
                    return classSet.iterator().next();
                }else{
                    //如果多于两个实现类并且用户没指定其中实现类，则抛出异常
                    throw new RuntimeException("multiple implemented classes found in" + fieldClass.getName() +
                            "please set @autowired value");
                }
            }else {
                for (Class<?> clazz: classSet) {
                    if (autowiredValue.equals(clazz.getSimpleName())){
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
