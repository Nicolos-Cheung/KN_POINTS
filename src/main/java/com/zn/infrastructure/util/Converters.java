package com.zn.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实体和dto转换方法
 */
public class Converters {
    private static final Logger logger = LoggerFactory.getLogger(Converters.class);

    public static <D, Q> D convertToDto(Q q, Class<D> dClazz) {
        if (q == null) {
            return null;
        }

        try {
            D d = dClazz.newInstance();
            BeanUtils.copyProperties(q, d);
            return d;
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("", e);
            return null;
        }

    }

    public static <D, Q> List<D> convertToList(List<Q> qList, Class<D> dClass) {
        if (qList == null) {
            return Collections.emptyList();
        }

        return qList.stream().map(q -> convertToDto(q, dClass)).collect(Collectors.toList());
    }

}
