package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 * 是否对称二叉树
 *
 * @author ning
 * @date 2020/11/20
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return check(root, root);

    }

    private boolean check(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;

        /**
         * 递归比较左右子节点
         */
        return check(t1.left, t2.right) && check(t1.right, t2.left);


    }
}
