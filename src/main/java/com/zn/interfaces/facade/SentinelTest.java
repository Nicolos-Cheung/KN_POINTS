package com.zn.interfaces.facade;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */

@RestController
@RequestMapping("/sentinel")
public class SentinelTest {

    @GetMapping("/hello")
    public String helloSentinel() {

        try {
            SphU.entry("hello");
            return "hello sentinel~";

        } catch (BlockException e) {

            return "系统繁忙，请稍后再试";
        }

    }


    @PostConstruct
    public void initFlowRules() {

        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("Hello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

    }
}
