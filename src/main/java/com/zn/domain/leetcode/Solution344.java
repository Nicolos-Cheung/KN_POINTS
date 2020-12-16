package com.zn.domain.leetcode;

/**
 * 反转字符串
 *
 * tag 字符串
 * @author ning
 * @date 2020/04/22
 */
public class Solution344 {


    public static void main(String[] args) {
        char[] arr = {'a','v','c'};
        reverseString(arr);
        for (char c : arr) {
            System.out.println(c);
        }
    }


    public static void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}
