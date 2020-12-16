package com.zn.domain.designpattern.command;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/10
 */
public class Light {

    private String color;

    public Light(String color) {
        this.color = color;
    }

    public void lightOn() {
        System.out.println(color + "灯亮");
    }

    public void lightOff() {
        System.out.println(color + "灯灭");
    }
}
