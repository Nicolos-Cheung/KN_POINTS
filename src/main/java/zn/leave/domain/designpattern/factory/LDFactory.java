package zn.leave.domain.designpattern.factory;

import ddd.leave.domain.designpattern.factory.bean.*;
import zn.leave.domain.designpattern.factory.bean.Pizza;
import zn.leave.domain.designpattern.factory.bean.SHCheesePizza;
import zn.leave.domain.designpattern.factory.bean.SHPepperPizza;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/13
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizze(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new SHCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new SHPepperPizza();
        }
        return pizza;
    }
}
