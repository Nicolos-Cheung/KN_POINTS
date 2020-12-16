package com.zn.domain.leetcode.arr;

import java.util.Arrays;

/**
 *
 * 查找最短无序子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author ning
 * @date 2020/12/10
 */
public class UnsortedSubarray {


    public int findUnsortedSubarray(int[] nums) {

        int[] clone = nums.clone();

        Arrays.sort(clone);

        int start = nums.length, end = 0;

        for(int i =0;i<nums.length;i++){

            if(nums[i]!=clone[i]){

                start = Math.min(start, i);
                end = Math.max(end,i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;

    }
}
