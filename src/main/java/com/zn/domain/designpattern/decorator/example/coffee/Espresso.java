package com.zn.domain.designpattern.decorator.example.coffee;

/**
 * 浓缩咖啡
 *
 * @author ning
 * @date 2020/02/01
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso Coffee";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
