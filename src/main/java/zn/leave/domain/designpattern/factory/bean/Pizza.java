package zn.leave.domain.designpattern.factory.bean;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/13
 */
public abstract class Pizza {


    protected String name;

    public  void prepare(){
        System.out.println(name + " prepare;");
    }

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }

}
