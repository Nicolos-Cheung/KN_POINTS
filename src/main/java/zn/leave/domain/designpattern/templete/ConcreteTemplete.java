package zn.leave.domain.designpattern.templete;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/14
 */
public class ConcreteTemplete extends AbstractTemplete {

    @Override
    void specialMethod() {
        System.out.println("不同模板具体的算法实现");
    }
}
