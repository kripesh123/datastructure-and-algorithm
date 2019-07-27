package com.kripesh.interviewqa.arraysandstrings;

/**
 * @author kripesh
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome2("Tact Coa"));
        System.out.println(isPermutationOfPalindrome3("Tact Coa"));
    }

    /**
     * Solution 1: Time complexity is O(n)
     * @param phrase
     * @return
     */
    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }


    /**
     * Solution 2: Time complexity is O(n)
     * @param phrase
     * @return
     */
    public static boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    /**
     * Solution 3: Time complexity is O(n)
     * @param phrase
     * @return
     */
    public static boolean isPermutationOfPalindrome3(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /**
     * Create a bit vector for the String. Eg, for each letter with the value i, toggle the iTH bit
     * @param phrase
     * @return
     */
    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /**
     * Toggle the iTH bit in the integer
     * @param bitVector
     * @param x
     * @return
     */
    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /**
     * Check that exactly one bit is set by subtracting one from the integer and adding it with the original integer
     * @param bitVector
     * @return
     */
    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector -1 )) == 0;
    }

    /**
     * Check that no more than one character has an odd count
     * @param table
     * @return
     */
    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }

    /**
     * Count how many times each character appears.
     * @param phrase
     * @return
     */
    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /**
     * Map each character to a number. a -> 0, b -> 1, c -> 2 ......n
     * Case insensitive. None map to -1
     * @param c
     * @return
     */
    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


}
