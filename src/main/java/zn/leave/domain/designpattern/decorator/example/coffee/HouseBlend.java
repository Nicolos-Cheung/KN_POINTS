package zn.leave.domain.designpattern.decorator.example.coffee;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/01
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
