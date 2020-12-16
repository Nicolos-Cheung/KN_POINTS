package com.zn.domain.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 两个相同字母之间的最大长度，
 *
 * map记录 字符首次出现的下标
 * maxm ->2
 *
 * @author ning
 * @date 2020/12/04
 */
public class MaxSubString {

    public static void main(String[] args) {
        int mam = solution("mam");
        System.out.println();

    }

    public static int solution(String str) {

        char[] chars = str.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();

        int max = -1;
        for (int i = 0; i < chars.length; i++) {

            Integer index = indexMap.get(chars[i]);
            if (index != null) {

                max = Math.max(max, i - index - 1);

            } else {
                indexMap.put(chars[i], i);
            }
        }

        return max;

    }
}
