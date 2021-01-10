package org.myspring.core.inject;

import com.lxj.controller.ItemController;
import org.junit.Assert;
import org.junit.Test;
import org.myspring.core.BeanContainer;

public class DependencyInjectorTest {

    @Test
    public void doIocTest() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.lxj");
        Assert.assertEquals(true, beanContainer.isLoaded());
        ItemController controller = (ItemController) beanContainer.getBean(ItemController.class);
        Assert.assertEquals(true, controller instanceof ItemController);
        Assert.assertEquals(null, controller.getItemService());
        new DependencyInjector().doIoc();
        Assert.assertNotEquals(null, controller.getItemService());
    }
}
