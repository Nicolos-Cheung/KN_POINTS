package zn.leave.domain.leetcode.sys_design;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ning
 * @date 2020/12/14
 */
public class MaxSlidingWindow {

    ArrayDeque<Integer> queue = new ArrayDeque();


    // point:移除比当前元素小的所有元素，它们不可能是最大的。

    public int[] maxSlidingWindow(int[] nums, int k) {


        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        int max_idx = 0;

        return null;

    }

    public void clean_deque(int i, int k, int[] nums) {
        // remove indexes of elements not from sliding window
        if (!queue.isEmpty() && Objects.equals(queue.getFirst(), i - k)) {
            queue.removeFirst();
        }


        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
            queue.removeLast();
        }
    }


}
