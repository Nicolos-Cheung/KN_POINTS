package zn.leave.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Simulator {

    public static void main(String[] args) {


        PurchaseRequest request = new PurchaseRequest(8000d);

        DepartmentApprover level1 = new DepartmentApprover();
        CollegeApprover level2 = new CollegeApprover();
        ViceSchoolApprover level3 = new ViceSchoolApprover();
        SchoolApprover level4 = new SchoolApprover();

        level1.setApprover(level2);
        level2.setApprover(level3);
        level3.setApprover(level4);
        level4.setApprover(level1); //形成环

        level1.processRequest(request);

    }
}
