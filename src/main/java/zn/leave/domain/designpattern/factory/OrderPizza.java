package zn.leave.domain.designpattern.factory;

import zn.leave.domain.designpattern.factory.bean.Pizza;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/13
 */
public class OrderPizza {

    AbsFactory factory;

    public OrderPizza(AbsFactory factory) {
        this.factory = factory;
    }

    public void createPizza(String orderType) {

        Pizza pizza = factory.createPizze(orderType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

    }

}
