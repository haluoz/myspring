package org.myspring.core.aop;

import com.lxj.controller.ItemController;
import org.junit.Test;
import org.myspring.core.BeanContainer;
import org.myspring.core.inject.DependencyInjector;

public class AspectWeaverTest {

    @Test
    public void doAop() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.lxj");
        new AspectWeaver().doAop();
        new DependencyInjector().doIoc();
        ItemController itemController = (ItemController) beanContainer.getBean(ItemController.class);
        itemController.getItemList();
    }
}
