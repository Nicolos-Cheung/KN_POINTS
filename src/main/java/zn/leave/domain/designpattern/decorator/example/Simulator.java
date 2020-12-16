package zn.leave.domain.designpattern.decorator.example;

import zn.leave.domain.designpattern.decorator.example.coffee.Beverage;
import zn.leave.domain.designpattern.decorator.example.coffee.Espresso;
import zn.leave.domain.designpattern.decorator.example.condiment.Mocha;
import zn.leave.domain.designpattern.decorator.example.condiment.Soy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Simulator {

    public static void main(String[] args) {


        Beverage beverage = new Espresso();
        System.out.println(beverage.desc() + ", $" + beverage.cost());

        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.desc() + ", $" + beverage.cost());
    }
}
