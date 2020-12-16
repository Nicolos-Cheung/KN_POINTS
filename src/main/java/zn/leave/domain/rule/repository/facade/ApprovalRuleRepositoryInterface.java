package zn.leave.domain.rule.repository.facade;

import zn.leave.domain.rule.entity.ApprovalRule;

public interface ApprovalRuleRepositoryInterface {

    int getLeaderMaxLevel(ApprovalRule rule);
}
