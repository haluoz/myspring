package org.myspring.core.aop;

import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.myspring.core.aop.aspect.AspectInfo;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lee
 */
public class AspectListExecutor implements MethodInterceptor {
    /**
     * 被代理的类
     */
    private Class<?> targetClass;
    /**
     * 实现类已排序的列表
     */
    @Getter
    private List<AspectInfo> aspectInfoList;

    public AspectListExecutor(Class<?> targetClass, List<AspectInfo> aspectInfoList) {
        this.targetClass = targetClass;
        this.aspectInfoList = sortAspectInfoList(aspectInfoList);;
    }

    /**
     * 按照order的值进行剩升序排序，确保order小的值先被织入
     * @param aspectInfoList
     * @return
     */
    private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
        Collections.sort(aspectInfoList, new Comparator<AspectInfo>() {
            @Override
            public int compare(AspectInfo o1, AspectInfo o2) {
                return o1.getOrderIndex() - o2.getOrderIndex();
            }
        });
        return aspectInfoList;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnValue = null;
        if (aspectInfoList == null || aspectInfoList.isEmpty()){
            return returnValue;
        }
        //1.按照order的顺序升序执行完所有Aspect的before方法
        invokeBeforeAdvice(method,args);
        try {
            //2.执行被代理类的方法
            returnValue = methodProxy.invokeSuper(o, args);
            //3.如果被代理类方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturning方法
            returnValue = invokeAfterReturningAdvice(method,args,returnValue);
        } catch (Exception e) {
            //4.如果被代理类方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
            invokeAfterThrowingAdvice(method,args, e);
        }
        return returnValue;
    }

    private void invokeAfterThrowingAdvice(Method method, Object[] args, Exception e) throws Throwable {
        for (int i = aspectInfoList.size()-1; i>=0 ; i--) {
            aspectInfoList.get(i).getAspectObject().afterThrowing(targetClass,method,args,e);
        }
    }

    private Object invokeAfterReturningAdvice(Method method, Object[] args, Object returnValue) throws Throwable {
        Object result = null;
        for (int i = aspectInfoList.size()-1; i>=0 ; i--) {
            result = aspectInfoList.get(i).getAspectObject().afterReturning(targetClass,method,args,returnValue);
        }
        return result;
    }

    private void invokeBeforeAdvice(Method method, Object[] args) throws Throwable {
        for (AspectInfo aspectInfo :aspectInfoList) {
            aspectInfo.getAspectObject().before(targetClass,method,args);
        }
    }
}
