package zn.leave.domain.leetcode.string;

/**
 * 是否是回文字符串
 *
 * @author ning
 * @date 2020/04/22
 */
public class Palindrome {


    public static void main(String[] args) {

        System.out.println(isPalindrome("OP"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!Character.isAlphabetic(a)) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(b)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }


}
