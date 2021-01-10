package org.myspring.core.aop.annotation;

import java.lang.annotation.*;

/**
 * @author lee
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 需要被织入横切逻辑的注解标签
     * @return
     */
    Class<? extends Annotation> value();
}
