package com.kripesh.interviewqa.arraysandstrings;

/**
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * Cannot use additional data structures.
 * @author kripesh
 */
public class IsUnique {

    public static void main(String[] args) {
       // System.out.println(isUniqueChars("abcdefghijkl"));
        System.out.println(inUniqueChars2("abacdefghijkl"));
    }

    /**
     * time complexity is O(n)
     * space complexity is 0(1)
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128 ) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {

            // char to ==> int
            int val = str.charAt(i);
            // Already found int val in string
            if(charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    /**
     * time complexity is O(n2)
     * space complexity is 0(1)
     * @param str
     * @return
     */
    public static boolean inUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val )) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
