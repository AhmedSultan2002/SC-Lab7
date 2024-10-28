package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileSearch {

    // Method to search for multiple files in the directory
    public static List<String> searchFiles(File directory, List<String> fileNames, boolean caseSensitive) {
        List<String> foundFiles = new ArrayList<>();
        if (!directory.exists() || !directory.isDirectory()) {
            return foundFiles; // Return an empty list if the directory is invalid
        }
        searchFilesRecursive(directory, fileNames, caseSensitive, foundFiles);
        return foundFiles;
    }

    // Recursive method to search for the files
    private static void searchFilesRecursive(File directory, List<String> fileNames, boolean caseSensitive, List<String> foundFiles) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively search in subdirectories
                searchFilesRecursive(file, fileNames, caseSensitive, foundFiles);
            } else {
                // Check each file name against the list of search targets
                for (String targetFileName : fileNames) {
                    if (matches(file.getName(), targetFileName, caseSensitive)) {
                        foundFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    // Method to check if two file names match based on case sensitivity
    private static boolean matches(String fileName, String targetFileName, boolean caseSensitive) {
        if (caseSensitive) {
            return fileName.equals(targetFileName);
        } else {
            return fileName.equalsIgnoreCase(targetFileName);
        }
    }

    // Method to count occurrences of a specific file in the directory
    public static int countFileOccurrences(File directory, String fileName, boolean caseSensitive) {
        if (!directory.exists() || !directory.isDirectory()) {
            return 0;
        }
        return countOccurrencesRecursive(directory, fileName, caseSensitive);
    }

    // Recursive method to count occurrences
    private static int countOccurrencesRecursive(File directory, String fileName, boolean caseSensitive) {
        int count = 0;
        File[] files = directory.listFiles();
        if (files == null) {
            return count;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively count in subdirectories
                count += countOccurrencesRecursive(file, fileName, caseSensitive);
            } else {
                // Check for matches
                if (matches(file.getName(), fileName, caseSensitive)) {
                    count++;
                }
            }
        }
        return count;
    }
}
