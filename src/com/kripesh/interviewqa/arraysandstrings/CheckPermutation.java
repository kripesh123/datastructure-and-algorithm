package com.kripesh.interviewqa.arraysandstrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 * @author kripesh
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(permutation("god", "dog"));
        System.out.println(permutation2("god", "dog"));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String (content);
    }

    /**
     * Solution 1 : Sort the Strings
     * @param s
     * @param t
     * @return
     */
    public static boolean permutation (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    /**
     * Solution 2 : Check if the two strings have identical character counts.
     * @param s
     * @param t
     * @return
     */
    public static boolean permutation2 (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Assumption
        int[] letters = new int[128];

        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            // Count number of each chat in s
            letters[c]++;
        }

        for (int i = 0 ; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
