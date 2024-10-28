package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationGenerator {

    /**
     * Generates permutations of the given string, allowing the user to specify
     * whether to treat duplicates as unique.
     *
     * @param str the input string
     * @param treatDuplicatesAsUnique true to treat duplicates as unique; false otherwise
     * @return a list of permutations of the string
     */
    public List<String> generatePermutations(String str, boolean treatDuplicatesAsUnique) {
        List<String> result = new ArrayList<>();
        // Handle empty string case
        if (str == null || str.isEmpty()) {
            return result; // Return an empty list
        }
        
        if (treatDuplicatesAsUnique) {
            generatePermutationsHelper("", str, result);
        } else {
            generatePermutationsWithDuplicates("", str, result);
        }
        
        return result;
    }

    /**
     * Helper method to generate all permutations recursively (including duplicates).
     *
     * @param prefix the current prefix
     * @param remaining the remaining characters
     * @param result the list to store permutations
     */
    private void generatePermutationsWithDuplicates(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix); // Base case: add the complete permutation
        } else {
            for (int i = 0; i < n; i++) {
                // Generate new remaining string by excluding the current character
                generatePermutationsWithDuplicates(prefix + remaining.charAt(i), 
                                                    remaining.substring(0, i) + remaining.substring(i + 1, n), 
                                                    result);
            }
        }
    }

    /**
     * Helper method to generate unique permutations recursively.
     *
     * @param prefix the current prefix
     * @param remaining the remaining characters
     * @param result the list to store unique permutations
     */
    private void generatePermutationsHelper(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix); // Base case: add the complete permutation
        } else {
            HashSet<Character> usedChars = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char currentChar = remaining.charAt(i);
                // Skip duplicate characters
                if (!usedChars.contains(currentChar)) {
                    usedChars.add(currentChar);
                    // Generate new remaining string by excluding the current character
                    generatePermutationsHelper(prefix + currentChar, 
                                                remaining.substring(0, i) + remaining.substring(i + 1, n), 
                                                result);
                }
            }
        }
    }
}
