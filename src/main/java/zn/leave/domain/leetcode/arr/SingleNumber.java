package zn.leave.domain.leetcode.arr;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/11
 */
public class SingleNumber {

    public static void main(String[] args) {

        int arr[] = {3, 4, 3, 3};

        System.out.println(singleNumber(arr));
    }


    public static int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < 32; i++) {

            int bitcount = 0;

            //指针左移i位
            int idx = 1 << i;

            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & idx) > 0) {
                    bitcount++;
                }
            }
            //  找到数字
            if (bitcount % 3 > 0) {
                res |= idx;
            }
        }

        return res;
    }
}
