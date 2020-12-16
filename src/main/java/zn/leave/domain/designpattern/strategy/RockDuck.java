package zn.leave.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class RockDuck extends Duck {

    public RockDuck(){
        flyBehavior = new FlyRocketPower();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a rock duck");
    }
}
