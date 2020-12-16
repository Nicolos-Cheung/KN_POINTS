package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 *
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author ning
 * @date 2020/12/09
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode root = new TreeNode(0);
        root.val = t1.val + t2.val;
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;


    }
}
