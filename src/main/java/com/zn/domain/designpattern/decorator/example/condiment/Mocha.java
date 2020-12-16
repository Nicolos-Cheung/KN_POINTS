package com.zn.domain.designpattern.decorator.example.condiment;

import com.zn.domain.designpattern.decorator.example.coffee.Beverage;

/**
 * 调料 摩卡
 *
 * @author ning
 * @date 2020/02/01
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String desc() {
        return beverage.desc() + ", Mocha";
    }

    @Override
    public double cost() {

        return .20 + beverage.cost();
    }
}
