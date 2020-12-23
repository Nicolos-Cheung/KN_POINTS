package com.zn.domain.netty.netty.dubbo_rpc.provider;

import com.zn.domain.netty.netty.dubbo_rpc.service.TestService;
import org.apache.commons.lang.StringUtils;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class TestServiceImpl implements TestService {
    @Override
    public String upperString(String str) {
        return StringUtils.upperCase(str);
    }
}
