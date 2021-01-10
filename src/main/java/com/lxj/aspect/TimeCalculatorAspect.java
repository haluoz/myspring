package com.lxj.aspect;

import lombok.extern.slf4j.Slf4j;
import org.myspring.core.annotation.Controller;
import org.myspring.core.aop.annotation.Aspect;
import org.myspring.core.aop.annotation.Order;
import org.myspring.core.aop.aspect.DefaultAspect;

import java.lang.reflect.Method;

/**
 * @author lee
 */
@Aspect(value = Controller.class)
@Order(1)
@Slf4j
public class TimeCalculatorAspect extends DefaultAspect {
    private long startTime;
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        log.info("开始计时，执行类是[{}],执行方法是[{}],参数是[{}]", targetClass.getName(), method, args);
        startTime = System.currentTimeMillis();
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        log.info("计时结束，执行类是[{}],执行方法是[{}],参数是[{}],返回值是[{}],耗时为[{}]",
                targetClass.getName(), method, args, returnValue, costTime);
        return returnValue;
    }
}
