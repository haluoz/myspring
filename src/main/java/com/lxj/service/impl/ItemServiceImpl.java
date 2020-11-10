package com.lxj.service.impl;

import com.lxj.entity.Item;
import com.lxj.service.ItemService;
import org.myspring.core.annotation.Service;

import java.util.List;

/**
 * @author lee
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> selectAll(Item item, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<Item> addItem(Item item) {
        return null;
    }

    @Override
    public List<Item> modifyItem(Item item) {
        return null;
    }

    @Override
    public List<Item> deleteItem(Item item) {
        return null;
    }
}
