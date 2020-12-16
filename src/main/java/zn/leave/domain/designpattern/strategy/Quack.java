package zn.leave.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack~（鸭子的一种叫声）");
    }
}
