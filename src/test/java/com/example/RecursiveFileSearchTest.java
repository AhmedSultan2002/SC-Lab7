package com.example;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecursiveFileSearchTest {

    @Test
    public void testMultipleFilesFound() {
        File rootDir = new File("src/test/resources/testDir");
        List<String> fileNames = Arrays.asList("testFile.txt", "nestedFile.txt");
        List<String> result = RecursiveFileSearch.searchFiles(rootDir, fileNames, true);
        assertEquals(2, result.size(), "Both files should be found.");
    }

    @Test
    public void testFileOccurrences() {
        File rootDir = new File("src/test/resources/testDir");
        String fileName = "testFile.txt";
        int occurrences = RecursiveFileSearch.countFileOccurrences(rootDir, fileName, true);
        assertEquals(1, occurrences, "The file should appear exactly once.");
    }

    @Test
    public void testCaseInsensitiveSearch() {
        File rootDir = new File("src/test/resources/testDir");
        List<String> fileNames = Arrays.asList("TESTFILE.TXT", "NESTEDFILE.TXT");
        List<String> result = RecursiveFileSearch.searchFiles(rootDir, fileNames, false);
        assertEquals(2, result.size(), "Case-insensitive search should find both files.");
    }

    @Test
    public void testFileNotFound() {
        File rootDir = new File("src/test/resources/testDir");
        List<String> fileNames = Arrays.asList("nonExistentFile.txt");
        List<String> result = RecursiveFileSearch.searchFiles(rootDir, fileNames, true);
        assertTrue(result.isEmpty(), "No files should be found.");
    }

    @Test
    public void testEmptyDirectory() {
        File emptyDir = new File("src/test/resources/testDir/emptyDir");
        List<String> fileNames = Arrays.asList("someFile.txt");
        List<String> result = RecursiveFileSearch.searchFiles(emptyDir, fileNames, true);
        assertTrue(result.isEmpty(), "No files should be found in an empty directory.");
    }

    @Test
    public void testInvalidDirectory() {
        File invalidDir = new File("src/test/resources/nonExistentDir");
        List<String> fileNames = Arrays.asList("someFile.txt");
        List<String> result = RecursiveFileSearch.searchFiles(invalidDir, fileNames, true);
        assertTrue(result.isEmpty(), "Searching in a non-existent directory should return an empty list.");
    }
}
