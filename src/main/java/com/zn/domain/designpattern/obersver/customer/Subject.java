package com.zn.domain.designpattern.obersver.customer;

/**
 * 主题
 *
 * @author ning
 * @date 2020/01/26
 */
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
