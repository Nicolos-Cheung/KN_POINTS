package com.zn.domain.designpattern.command;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/10
 */
public class Simulator {

    public static void main(String[] args) {

        Queue<Command>  queue = new LinkedBlockingQueue<>();
        Light light = new Light("红色");

        queue.add(new LightOnCommand(light));
        queue.add(new LightOffCommand(light));
        queue.add(new LightOnCommand(light));
        queue.add(new LightOffCommand(light));

        //消费队列任务
        while (queue.peek()!=null){
            Command peek = queue.poll();
            peek.execute();
        }
    }
}
