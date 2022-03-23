package com.lxj.designpatterns.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Xingjing.Li
 * @since 2022/2/10
 */
@Slf4j
public class IvoryTower implements WizardTower {
    @Override
    public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}
