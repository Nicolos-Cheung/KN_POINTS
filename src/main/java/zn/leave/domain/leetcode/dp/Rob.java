package zn.leave.domain.leetcode.dp;

/**
 * 打家劫舍
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 非常好的动态规划基础题
 *
 * @author ning
 * @date 2020/12/16
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 3};

        int rob = rob(nums);

        System.out.println(rob);

    }


    public static int rob(int[] nums) {

        int size = nums.length;

        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return nums[0];
        }
        int[] state = new int[nums.length];
        state[0] = nums[0];
        state[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < size; i++) {
            state[i] = Math.max(state[i - 1], state[i - 2] + nums[i]);
        }

        return state[size - 1];

    }


}
