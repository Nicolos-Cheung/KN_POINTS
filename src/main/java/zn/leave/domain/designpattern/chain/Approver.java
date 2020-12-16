package zn.leave.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public abstract class Approver {

    Approver approver;
    String approverName;


    /**
     * 下一个处理者
     *
     * @param approver
     */
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 处理审批请求方法
     */
    public abstract void processRequest(PurchaseRequest request);


}
