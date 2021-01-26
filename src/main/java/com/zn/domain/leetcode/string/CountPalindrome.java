package com.zn.domain.leetcode.string;

/**
 * 输入字符串，返回有多少个回文子串
 *
 * @author ning
 * @date 2021/01/07
 */
public class CountPalindrome {


    //abab
    public int countSubstrings(String s) {

        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {

            int l = i / 2;
            int r = i / 2 + i % 2;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }

        }
        return ans;


    }

}
