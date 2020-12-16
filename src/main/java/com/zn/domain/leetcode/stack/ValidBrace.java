package com.zn.domain.leetcode.stack;

import java.util.Stack;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/06
 */
public class ValidBrace {

    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println();
    }

    public static boolean isValid(String s) {

        Stack<Character> left = new Stack();

        char[] chars = s.toCharArray();

        for (char aChar : chars) {

            if (aChar == '{') {
                left.push('}');
            } else if (aChar == '[') {
                left.push(']');
            } else if (aChar == '(') {
                left.push(')');
            } else {
                if (left.empty() || left.pop() != aChar) {
                    return false;
                }
            }
        }

        // 注意****存在剩余未匹配括号
        if (!left.empty()) {
            return false;
        }
        return true;
    }

}
