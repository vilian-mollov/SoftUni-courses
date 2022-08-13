package StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class N6WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordsCountMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line = reader.readLine();
            String[] wordsArray = line.split("\\s+");
            addWordsToTheMap(wordsCountMap, wordsArray);

            BufferedReader readerText = new BufferedReader(new FileReader("text.txt"));
            String lineToCheck = readerText.readLine();
            String[] wordsInLineToCheck = lineToCheck.split("\\s+");
            getDataFromTheTextToTheMap(wordsCountMap, wordsInLineToCheck);

            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writeToTheFileResult(wordsCountMap, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToTheFileResult(Map<String, Integer> wordsCountMap, BufferedWriter writer) throws IOException {
        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            writer.write(entry.getKey() + " - " + entry.getValue() + System.lineSeparator());
        }
    }

    private static void getDataFromTheTextToTheMap(Map<String, Integer> wordsCountMap, String[] wordsInLineToCheck) {
        for (int i = 0; i < wordsInLineToCheck.length; i++) {
            String word = wordsInLineToCheck[i];
            if (wordsCountMap.containsKey(word)) {
                int times = wordsCountMap.get(word);
                times++;
                wordsCountMap.put(word, times);
            }
        }
    }

    private static void addWordsToTheMap(Map<String, Integer> wordsCountMap, String[] wordsArray) {
        for (int i = 0; i < wordsArray.length; i++) {
            wordsCountMap.putIfAbsent(wordsArray[i], 0);
        }
    }
}
