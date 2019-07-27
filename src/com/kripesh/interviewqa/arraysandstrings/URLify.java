package com.kripesh.interviewqa.arraysandstrings;

/**
 * Replace all spaces in a string with '%20'.
 * @author kripesh
 */
public class URLify {

    public static void main(String[] args) {
        String text = "Mr Kripesh Bista    ";
        System.out.println("Input: " + text);
        replaceSpaces(text.toCharArray(), 16);
    }

    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        index = trueLength + spaceCount * 2;
        if (trueLength < str.length)
            // End array
            str[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i-- ) {
            if (str[i] == ' ') {
                str[index - 1] =  '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        System.out.println(str);
    }
}
