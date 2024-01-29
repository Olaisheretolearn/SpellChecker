import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String filePath = "src/words.txt";

        try (FileReader faucet = new FileReader(filePath);
             BufferedReader container = new BufferedReader(faucet)) {

            String line;
            Scanner scanner = new Scanner(System.in);
            String word = scanner.next().toLowerCase();
            System.out.println("Did you mean any of these ");

            Map<Integer, List<String>> suggestions = new HashMap<>();
            int count = 0;
            int threshold = 2; // Set a threshold for Levenshtein distance

            while ((line = container.readLine()) != null) {
                count++;

                // Check exact match
                if (line.toLowerCase().equals(word)) {
                    System.out.println(line + " found at line " + count + " (Exact match)");
                }

                // Check Levenshtein distance
                int distance = calculateLevenshteinDistance(line.toLowerCase(), word);
                if (distance <= threshold) {
                    suggestions.computeIfAbsent(distance, k -> new ArrayList<>()).add(line);
                }
            }

            // Print suggestions in increasing order of Levenshtein distance
            for (int distance : suggestions.keySet()) {
                List<String> words = suggestions.get(distance);
                for (String suggestedWord : words) {
                    System.out.println(suggestedWord + " (Levenshtein distance: " + distance + ")");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Levenshtein distance calculation
    private static int calculateLevenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(s1.charAt(i - 1), s2.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

  private static int costOfSubstitution(char a, char b) {
    if (a == b) {
        return 0;
    } else {
        return 1;
    }
}


    private static int min(int... numbers) {
        return java.util.Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
