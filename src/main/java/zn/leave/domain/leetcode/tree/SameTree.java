package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/20
 */
public class SameTree {

    /**
     * 判断两棵树是否相同
     *
     * @param t1
     * @param t2
     * @return
     */
    public Boolean isSameTree(TreeNode t1, TreeNode t2) {

        /**
         * 比较两个根节点是否相同
         */
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;

        /**
         * 递归比较左右子节点
         */
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);

    }
}
