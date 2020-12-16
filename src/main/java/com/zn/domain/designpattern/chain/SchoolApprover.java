package com.zn.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public class SchoolApprover extends Approver {


    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 30000) {
            System.out.println("金额超过30000以上，校长审批");
        } else {
            approver.processRequest(request);
        }
    }
}
