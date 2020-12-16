package com.zn.domain.designpattern.factory;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/27
 */
public class Simulator {

    public static void main(String[] args) {

        OrderPizza orderPizza = new OrderPizza(new BJFactory());
        orderPizza.createPizza("cheese");

    }
}
