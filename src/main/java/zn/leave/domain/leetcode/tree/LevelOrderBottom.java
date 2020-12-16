package zn.leave.domain.leetcode.tree;

import zn.leave.domain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从底向上层次遍历
 *
 * @author ning
 * @date 2020/11/20
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        {

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

                //区别于层次遍历仅此一行
                result.add(0,r);
            }
            return result;
        }
    }


}
