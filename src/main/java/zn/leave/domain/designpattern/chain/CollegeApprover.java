package zn.leave.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public class CollegeApprover extends Approver {

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 5000 && request.getPrice() <= 10000) {
            System.out.println("金额小于等于10000, 由院长审批 (5000<x<=10000)");
        } else {
            approver.processRequest(request);
        }
    }
}
