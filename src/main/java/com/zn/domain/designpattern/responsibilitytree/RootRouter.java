package com.zn.domain.designpattern.responsibilitytree;

import com.zn.domain.designpattern.responsibilitytree.base.AbstractStrategyRouter;
import com.zn.domain.designpattern.responsibilitytree.base.StrategyHandler;

/**
 * This is Description
 *
 * @author ning
 * @date 2021/01/26
 */
public class RootRouter extends AbstractStrategyRouter<Integer, String> {

    @Override
    protected StrategyMapper registerStrategyMapper() {

        return new StrategyMapper<Integer, String>() {
            @Override
            public StrategyHandler<Integer, String> get(Integer param) {

                if (param > 0) {
                    return new HandlerA();
                } else {
                    return new HandlerB();
                }
            }
        };
    }
}
