package com.zn.infrastructure.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/04/12
 */
public class CustomBeanUtil {

    /**
     * 增量copy对象字段，空值不覆盖
     * @param src
     * @param target
     */
    public static void incrCopyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }


    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyProperties = new HashSet<>();
        for(PropertyDescriptor pd : pds) {

            Object fieldValue = src.getPropertyValue(pd.getName());

            if (fieldValue == null){
                emptyProperties.add(pd.getName());
            }
        }
        String[] result = new String[emptyProperties.size()];
        return emptyProperties.toArray(result);
    }
}
