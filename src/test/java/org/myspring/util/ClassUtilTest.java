package org.myspring.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.junit.Assert.*;

public class ClassUtilTest {

    @Test
    public void extraPackageClass() {
        Set<Class<?>> classSet = ClassUtil.extraPackageClass("com.lxj.entity");
        Assert.assertEquals(1, classSet.size());
    }
}
