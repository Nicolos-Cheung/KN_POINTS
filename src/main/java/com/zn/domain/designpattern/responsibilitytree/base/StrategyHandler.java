package com.zn.domain.designpattern.responsibilitytree.base;

/**
 * This is Description
 *
 * @author ning
 * @date 2021/01/26
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);

}
