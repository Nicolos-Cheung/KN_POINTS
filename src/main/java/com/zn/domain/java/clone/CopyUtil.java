package com.zn.domain.java.clone;

import java.util.ArrayList;
import java.util.List;

/**
 * List对象 copy
 *
 * @author ning
 * @date 2020/03/08
 */
public class CopyUtil {

    /**
     * 浅拷贝
     * @param objs
     * @param <T>
     * @return
     */
    public static <T> List<T> shallowCopy(List<T> objs) {

        List<T> dupList = new ArrayList<>();

        for (T obj : objs) {
            dupList.add(obj);
        }


        return dupList;
    }


    /**
     * 浅拷贝
     * @param objs
     * @param <T>
     * @return
     */
    public static <T extends CustClone> List<T> deepCopy(List<T> objs) throws CloneNotSupportedException {

        List<T> dupList = new ArrayList<>();

        for (T obj : objs) {
            dupList.add((T) obj.clone());
        }
        return dupList;
    }

}
