package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/20
 */
public class PreorderByStack {

    public static void main(String[] args) {

        Stack<TreeNode> stack = new Stack();
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {

            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }

        return result;
    }


}
