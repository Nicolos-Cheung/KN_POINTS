package zn.leave.domain.designpattern.templete;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/14
 */
public abstract class AbstractTemplete {

    /**
     * 模板方法，被声明final以免子类覆盖，保护算法 & 执行顺序
     */
    final void templeteMethod() {

        commonMethod();

        specialMethod();

        hook();

    }

    final void commonMethod() {
        System.out.println("算法共性部分实现");
    }

    abstract void specialMethod();

    /**
     * 子类可以根据情况选择是否覆盖
     */
    void hook(){

    }

}
