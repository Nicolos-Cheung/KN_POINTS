package zn.leave.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public class DepartmentApprover extends Approver {


    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 5000) {
            System.out.println("金额小于等于5000, 由教学主任审批");
        } else {
            approver.processRequest(request);
        }
    }
}
