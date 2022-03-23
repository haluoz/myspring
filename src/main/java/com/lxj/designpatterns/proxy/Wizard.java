package com.lxj.designpatterns.proxy;

/**
 * @author Xingjing.Li
 * @since 2022/2/10
 */
public class Wizard {
    private final String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
