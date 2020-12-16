package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 * 二叉树的最大深度
 *
 * tag 二叉树
 * @author ning
 * @date 2020/04/15
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        // 分别递归求左右子树的深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 最后将两者最大的深度再加上根节点即为最大深度
        return Math.max(left, right) + 1;

    }
}
