package com.zn.domain.designpattern.responsibilitytree;

import com.zn.domain.designpattern.responsibilitytree.base.StrategyHandler;

/**
 * This is Description
 *
 * @author ning
 * @date 2021/01/26
 */
public class HandlerC implements StrategyHandler<Integer, String> {

    @Override
    public String apply(Integer param) {

        return "Handler C ...";

    }



}
