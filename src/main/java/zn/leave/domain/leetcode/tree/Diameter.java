package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

/**
 * 二叉树直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author ning
 * @date 2020/12/07
 */
public class Diameter {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        // 计算d_node即L+R+1 并更新ans
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }


}
