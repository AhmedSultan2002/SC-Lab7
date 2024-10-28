package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationGeneratorTest {

    @Test
    void testGeneratePermutationsWithValidStringAndUnique() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations("abc", false);
        assertEquals(6, permutations.size()); // Expect 6 permutations: "abc", "acb", "bac", "bca", "cab", "cba"
    }

    @Test
    void testGeneratePermutationsWithValidStringAndDuplicatesAsUnique() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations("abc", true);
        assertEquals(6, permutations.size()); // Expect 6 permutations
    }

    @Test
    void testGeneratePermutationsWithEmptyString() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations("", false);
        assertTrue(permutations.isEmpty()); // Expect empty list for empty string
    }

    @Test
    void testGeneratePermutationsWithNull() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations(null, false);
        assertTrue(permutations.isEmpty()); // Expect empty list for null input
    }

    @Test
    void testGeneratePermutationsWithSingleCharacter() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations("a", false);
        assertEquals(1, permutations.size()); // Expect only one permutation
        assertTrue(permutations.contains("a"));
    }

    @Test
    void testGeneratePermutationsWithDuplicateCharacters() {
        PermutationGenerator generator = new PermutationGenerator();
        List<String> permutations = generator.generatePermutations("aab", false);
        assertEquals(6, permutations.size()); // Expect 6 permutations: "aab", "aab", "aba", "aba", "baa", "baa"

        // Test with duplicates treated as unique
        List<String> uniquePermutations = generator.generatePermutations("aab", true);
        assertEquals(3, uniquePermutations.size()); // Expect 3 unique permutations: "aab", "aba", "baa"
        assertTrue(uniquePermutations.contains("aab"));
        assertTrue(uniquePermutations.contains("aba"));
        assertTrue(uniquePermutations.contains("baa"));
    }
}
