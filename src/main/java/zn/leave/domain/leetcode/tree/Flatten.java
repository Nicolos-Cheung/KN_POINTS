package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author ning
 * @date 2020/11/23
 */
public class Flatten {

    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        flatten(treeNode);

    }

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        List<TreeNode> l = new ArrayList();
        preOrder(l, root);
        for (int i = 0; i < l.size() - 1; i++) {
            l.get(i).right = l.get(i+1);
            l.get(i).left = null;

        }

        System.out.println();

    }

    public static void preOrder(List<TreeNode> l, TreeNode root) {
        if (root != null) {
            l.add(root);
            preOrder(l, root.left);
            preOrder(l, root.right);
        }
    }
}
