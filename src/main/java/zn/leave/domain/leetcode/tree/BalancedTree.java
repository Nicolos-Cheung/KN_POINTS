package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/20
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return (Math.abs(MaxDepth.maxDepth(root.left) - MaxDepth.maxDepth(root.right)) >= 1) && isBalanced(root.left) && isBalanced(root.right);
    }


}
