package org.myspring.core.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author lee
 */
public class ProxyCreator {
    /**
     * 创建动态代理对象并返回
     * @param targetClass 被代理的class对象
     * @param methodInterceptor 方法拦截器
     * @return
     */
    public static Object createProxy(Class<?> targetClass, MethodInterceptor methodInterceptor){
        return Enhancer.create(targetClass, methodInterceptor);
    }
}
