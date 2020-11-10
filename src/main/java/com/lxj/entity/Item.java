package com.lxj.entity;

import lombok.Data;

/**
 * @author lee
 */
@Data
public class Item {
    private int itemId;
    private String title;
    private double price;
    private String imgUrl;
    private String description;
    private int sales;
}
