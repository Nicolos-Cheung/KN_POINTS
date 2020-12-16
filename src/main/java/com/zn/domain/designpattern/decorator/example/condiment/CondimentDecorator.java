package com.zn.domain.designpattern.decorator.example.condiment;

import com.zn.domain.designpattern.decorator.example.coffee.Beverage;

/**
 * 调料 装饰类
 *
 * @author ning
 * @date 2020/02/01
 */
public abstract class CondimentDecorator extends Beverage {

    //所有调料需要实现该方法。
    public abstract String desc();


}
