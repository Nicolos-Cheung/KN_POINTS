package com.zn.domain.designpattern.decorator.example.condiment;

import com.zn.domain.designpattern.decorator.example.coffee.Beverage;

/**
 * 调料 豆浆
 *
 * @author ning
 * @date 2020/02/01
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String desc() {
        return beverage.desc() + ", Soy";
    }


    @Override
    public double cost() {

        return .30 + beverage.cost();
    }
}
