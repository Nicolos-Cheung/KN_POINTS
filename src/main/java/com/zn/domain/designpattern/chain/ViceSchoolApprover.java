package com.zn.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public class ViceSchoolApprover extends Approver {


    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 10000 && request.getPrice() <= 30000) {
            System.out.println("金额小于等于30000, 由副校长审批");
        } else {
            approver.processRequest(request);
        }
    }
}
