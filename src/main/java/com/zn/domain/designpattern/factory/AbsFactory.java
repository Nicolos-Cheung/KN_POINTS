package com.zn.domain.designpattern.factory;

import com.zn.domain.designpattern.factory.bean.Pizza;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/13
 */
public interface AbsFactory {

    /**
     * 让工厂子类具体实现
     */
    Pizza createPizze(String orderType);
}
