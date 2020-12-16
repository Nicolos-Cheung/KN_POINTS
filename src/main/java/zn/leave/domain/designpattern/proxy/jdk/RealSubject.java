package zn.leave.domain.designpattern.proxy.jdk;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/21
 */
public class RealSubject implements Subject{


    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}
