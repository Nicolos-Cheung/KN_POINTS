package zn.leave.domain.leetcode.test;

import java.util.*;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/04
 */
public class Test1 {

    public static void main(String[] args) {

        int[] arr1 = new int[]{0, 1, 2, 3, 4, 5};
        int[][] arr2 = new int[][]{{1, 3}, {4, 5}};

        int solution = solution(arr1, arr2);
        System.out.println(solution);

    }

    public static int solution(int[] arr1, int[][] arr2) {

        int res = 0;
        Map<Integer, Set<Integer>> mutexMap = new HashMap<>();

        for (int[] ints : arr2) {
            int a = ints[0];
            int b = ints[1];
            checkAndPut(mutexMap, a, b);
            checkAndPut(mutexMap, b, a);
        }

        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            Set<Integer> mutexs = mutexMap.get(arr1[i]);
            if (mutexs == null || !cur.removeAll(mutexs)) {
                cur.add(arr1[i]);
            } else {
                res++;
                cur = new ArrayList<>();
                cur.add(arr1[i]);
            }
        }
        if (cur.size() > 0) {
            return res + 1;
        }

        return res;

    }

    public static void checkAndPut(Map<Integer, Set<Integer>> mutexMap, Integer key, Integer value) {
        Set<Integer> integers = mutexMap.get(key);
        if (integers != null) {
            integers.add(value);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(value);

            mutexMap.put(key, set);
        }
    }
}
