package com.lxj.service;

import com.lxj.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> selectAll(Item item, int pageNum, int pageSize);
    List<Item> addItem(Item item);
    List<Item> modifyItem(Item item);
    List<Item> deleteItem(Item item);
}
