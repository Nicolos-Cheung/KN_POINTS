package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/20
 */
public class Preorder {

    public List<Integer> preorderTraversal(TreeNode root) {

        List l = new ArrayList();
        preOrder(root, l);
        return l;
    }

    public void preOrder(TreeNode root, List l) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        preOrder(root.left, l);
        preOrder(root.right, l);
    }

}
