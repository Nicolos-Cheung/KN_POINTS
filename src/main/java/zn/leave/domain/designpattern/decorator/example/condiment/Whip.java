package zn.leave.domain.designpattern.decorator.example.condiment;

import zn.leave.domain.designpattern.decorator.example.coffee.Beverage;

/**
 * 调料 豆浆
 *
 * @author ning
 * @date 2020/02/01
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String desc() {
        return beverage.desc() + ", Whip";
    }

    @Override
    public double cost() {

        return .25 + beverage.cost();
    }
}
