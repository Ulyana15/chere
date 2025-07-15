package myProject.coffee;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(removeDublicates(new int[]{0, 5, 5, 5, 5, 5, 4})));
    }

    public static int[] removeDublicates(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int n : input) {
            resultSet.add(n);
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i] = num;
            i ++;
        }
        return result;
    }

    public static boolean isAnagram(final String s1, final String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String str1 = s1.toLowerCase();
        String str2 = s2.toLowerCase();
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
