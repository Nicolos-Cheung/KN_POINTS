package zn.leave.domain.designpattern.factory;

import zn.leave.domain.designpattern.factory.bean.BJCheesePizza;
import zn.leave.domain.designpattern.factory.bean.BJPepperPizza;
import zn.leave.domain.designpattern.factory.bean.Pizza;

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
