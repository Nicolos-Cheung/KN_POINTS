package com.zn.domain.leetcode.tree;

import com.zn.domain.leetcode.bean.TreeNode;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/03
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        invert(root);
        return root;
    }

    public void invert(TreeNode root) {

        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invert(root.left);
            invert(root.right);
        }
    }


}
