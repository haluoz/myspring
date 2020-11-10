package com.lxj.controller;

import com.lxj.base.BaseResult;
import com.lxj.entity.Item;
import com.lxj.service.ItemService;
import org.myspring.core.annotation.Controller;

import java.util.List;

/**
 * @author lee
 */
@Controller
public class ItemController {
    private ItemService itemService;

    public BaseResult getItemList(){
        Item item = new Item();
        List<Item> items = itemService.selectAll(item, 1, 10);
        return BaseResult.create(items);
    }
}
