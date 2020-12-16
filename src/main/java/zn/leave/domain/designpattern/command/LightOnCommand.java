package zn.leave.domain.designpattern.command;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/10
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
