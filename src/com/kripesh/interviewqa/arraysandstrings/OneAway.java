package com.kripesh.interviewqa.arraysandstrings;

/**
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * @author kripesh
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "bae"));

    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()){
            return oneEditReplace(first,second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else  if (first.length() -1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    /**
     * Check if you can insert a character into s1 to make s2
     * @param s1
     * @param s2
     * @return
     */
    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifferent = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifferent) {
                    return false;
                }
                foundDifferent = true;
            }
        }
        return true;
    }
}
