import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String fileName = "Variables.txt";
        Map<String, Integer> wordFreq = new HashMap<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                    }
                }
            }
            br.close();
            fr.close();
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFreq.entrySet());
            sortedWords.sort((a, b) -> {
                int freqCompare = Integer.compare(b.getValue(), a.getValue());
                return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
            });
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}