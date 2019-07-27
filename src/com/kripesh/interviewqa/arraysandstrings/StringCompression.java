package com.kripesh.interviewqa.arraysandstrings;

/**
 * @author kripesh
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String str) {
        StringBuilder sb= new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, append this char to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return sb.length() < str.length() ? sb.toString() : str ;
    }
}
