package com.zn.domain.designpattern.responsibilitytree;

/**
 * This is Description
 *
 * @author ning
 * @date 2021/01/26
 */
public class Simulator {

    public static void main(String[] args) {

        RootRouter rootRouter = new RootRouter();

        rootRouter.applyStrategy(1);

        System.out.println();
    }
}
