package org.myspring.core;

import com.lxj.controller.ItemController;
import com.lxj.entity.Item;
import com.lxj.service.ItemService;
import com.lxj.service.impl.ItemServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.myspring.core.annotation.Service;

public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @Test
    public void loadBeansTest() {
        beanContainer = BeanContainer.getInstance();
        Assert.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.lxj");
        Assert.assertEquals(3, beanContainer.beanMapSize());
        Assert.assertEquals(true, beanContainer.isLoaded());
        ItemController itemController = (ItemController) beanContainer.getBean(ItemController.class);
        Assert.assertEquals(true, itemController instanceof ItemController);
        Item item = (Item) beanContainer.getBean(Item.class);
        Assert.assertEquals(null, item);
        Assert.assertEquals(1, beanContainer.getClassesByAnnotation(Service.class).size());
        Assert.assertEquals(true, beanContainer.getClassesBySuper(ItemService.class).contains(ItemServiceImpl.class));
    }
}
