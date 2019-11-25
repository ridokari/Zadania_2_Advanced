package com.company;

public class Words {
    private String Word;

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    Words(String word, int number) {
        super();
        Word = word;
        this.number = number;
    }

    private int number;

    @Override
    public String toString() {
        return "number= " + number + " " + "\"" + Word + "\"";
    }
}