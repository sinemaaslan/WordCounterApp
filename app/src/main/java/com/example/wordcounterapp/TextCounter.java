package com.example.wordcounterapp;

public class TextCounter {

    public int CountSentences(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.split("[.!?]+").length;
    }

    public int CountWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.trim().split("[\\s,.]+").length;
    }

    public int CountChars(String text) {
        return text.length();
    }

    public int CountNumbers(String text) {
        String[] numbers = text.split("[^0-9]+");

        int count = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}