package com.zn.domain.designpattern.command;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/10
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}
