package zn.leave.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can not fly");
    }
}
