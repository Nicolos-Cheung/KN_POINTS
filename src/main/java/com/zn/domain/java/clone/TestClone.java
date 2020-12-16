package com.zn.domain.java.clone;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/08
 */
public class TestClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneObject test1 = new CloneObject();

        List l = new ArrayList<>();
        l.add(test1);
        List list = CopyUtil.deepCopy(l);
        System.out.println(test1.equals(list.get(0)));

    }


}
