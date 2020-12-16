package com.zn.domain.designpattern.factory;

import com.zn.domain.designpattern.factory.bean.BJPepperPizza;
import com.zn.domain.designpattern.factory.bean.Pizza;
import com.zn.domain.designpattern.factory.bean.BJCheesePizza;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/13
 */
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizze(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
