package zn.leave.domain.leetcode.arr;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * @author ning
 * @date 2020/11/30
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] res = new int[]{3,2,4};
        int[] ints = twoSum(res, 6);
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {

            int need = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                if (need == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return null;
    }


}
