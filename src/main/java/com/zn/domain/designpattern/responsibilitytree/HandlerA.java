package com.zn.domain.designpattern.responsibilitytree;

import com.zn.domain.designpattern.responsibilitytree.base.StrategyHandler;

/**
 * This is Description
 *
 * @author ning
 * @date 2021/01/26
 */
public class HandlerA extends RootRouter implements StrategyHandler<Integer, String> {

    @Override
    public String apply(Integer param) {

        if (param < 1) {
            return "Handler A ...";
        }

        return applyStrategy(param);
    }


    /**
     * 如果是非叶子节点需要继承AbstractStrategyRouter
     */
    @Override
    protected StrategyMapper registerStrategyMapper() {
        return (StrategyMapper<Integer, String>) param -> {

            if (param < 1) {
                return new HandlerC();
            } else {
                return new HandlerD();
            }
        };
    }
}
