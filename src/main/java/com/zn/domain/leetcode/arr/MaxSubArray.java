package com.zn.domain.leetcode.arr;

/**
 * 最大子序和
 * <p>
 * 53
 *
 * @author ning
 * @date 2020/12/04
 */
public class MaxSubArray {

    /**
     * 贪心算法：若当前指针所指的元素之前的和小于0，则丢弃当前元素之前的数列
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int cur_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            cur_sum += nums[i];
            max = Math.max(max, cur_sum);
            if (cur_sum < 0) {
                cur_sum = 0;
            }
        }
        return max;
    }

}
