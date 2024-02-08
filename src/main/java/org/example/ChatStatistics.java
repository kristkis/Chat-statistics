package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChatStatistics {
    private Chat chat;

    public ChatStatistics(Chat chat) {
        this.chat = chat;
    }

    public HashMap<String, Integer> getNumberOfTexts(String sender1, String sender2) {
        int numberOfTexts = 0;
        int kristinasTexts = 0;
        int nikitasTexts = 0;
        HashMap<String, Integer> textNStats= new HashMap<>();
        for (Message message : chat.getMessages()) {
            if (!message.getText().isEmpty()) {
                numberOfTexts++;
                if (message.getSender().equals(sender1) )
                    kristinasTexts++;
                else if (message.getSender().equals(sender2))
                    nikitasTexts++;
                else System.out.println("Unknown sender");
            }
        }
        textNStats.put("numberOfTexts", numberOfTexts);
        textNStats.put("KristinaTexts", kristinasTexts);
        textNStats.put("NikitaTexts", nikitasTexts);
        return textNStats;
    }

    public Map<String, Integer> getMostPopularWords() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (Message message : chat.getMessages()) {
            if (!message.getText().isEmpty()) {
            String[] words = message.getText().split("[ ,.:;]+"); // initially regex was \\s+ - space ot multiple spaces
            for (String word : words) {
                //put a pair of word and number of occurrences in the map
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            }
        }
        // Sort the map by value (word count) in descending order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    public Map<String, Integer> getMostPopularEmoji() {
        Map<String, Integer> emojiCountMap = new HashMap<>();
        for (Message message : chat.getMessages()) {
            String emoji = message.getEmoji();
            if (!emoji.isEmpty()) {
                emojiCountMap.put(emoji, emojiCountMap.getOrDefault(emoji, 0) + 1);
            }
        }
        // Sort the map by value (word count) in descending order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        emojiCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
}
