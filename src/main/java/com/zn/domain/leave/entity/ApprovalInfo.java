package com.zn.domain.leave.entity;

import com.zn.domain.leave.entity.valueobject.ApprovalType;
import com.zn.domain.leave.entity.valueobject.Approver;
import lombok.Data;


/**
 * 审批意见实体
 */
@Data
public class ApprovalInfo {

    String approvalInfoId;
    Approver approver;
    ApprovalType approvalType;
    String msg;
    long time;

}
