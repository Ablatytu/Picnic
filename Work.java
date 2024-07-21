import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Work {

    public static void main(String[] args) {
        String filePath = "input.txt";
        List<String> words = readWordsFromFile(filePath);

        int wordCount = words.size();
        System.out.println("Total number of words: " + wordCount);

        String longestWord = findLongestWord(words);
        System.out.println("Longest word: " + longestWord);

        Map<String, Integer> wordFrequency = calculateWordFrequency(words);
        System.out.println("Word frequencies: " + wordFrequency);
    }

    private static List<String> readWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] splitWords = content.split("\\s+");
            words.addAll(Arrays.asList(splitWords));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    private static String findLongestWord(List<String> words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
