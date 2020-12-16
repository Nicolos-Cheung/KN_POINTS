package com.zn.domain.designpattern.decorator.example.coffee;

/**
 * 饮料基类
 *
 * @author ning
 * @date 2020/02/01
 */
public abstract class Beverage {

    String description = "Unkown Beverage";

    public String desc() {
        return description;
    }

    public abstract double cost();


}
