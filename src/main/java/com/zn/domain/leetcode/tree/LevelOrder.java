package com.zn.domain.leetcode.tree;

import com.zn.domain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/20
 */
public class LevelOrder {

    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        levelOrder(treeNode);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue();

        if (root == null) {
            return result;
        }
        queue.add(root);


        while (queue.peek() != null) {

            List<Integer> r = new ArrayList<>();
            int tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {

                TreeNode poll = queue.poll();
                r.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(r);
        }
        return result;
    }

}
