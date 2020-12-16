package zn.leave.domain.java.aop.aspect;

import zn.leave.domain.java.aop.AbsMethodAdvance;
import zn.leave.domain.java.aop.anno.Aspect;
import zn.leave.domain.java.aop.anno.PointCut;


@Aspect
public class TestAspect extends AbsMethodAdvance {

    /**
     * 全类名_方法名
     */
    @PointCut("ddd.leave.domain.java.aop.bean.Test_doSomeThing")
    public void testAspect() {
    }

    @Override
    public void doBefore() {
        System.out.println("do before");
    }

    @Override
    public void doAfter() {
        System.out.println("do after");
    }
}