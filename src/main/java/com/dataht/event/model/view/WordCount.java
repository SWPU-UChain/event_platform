package com.dataht.event.model.view;

public class WordCount {
    private String word;

    private int count;

    public WordCount() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WordCount))
            return false;

        WordCount w = (WordCount) obj;
        return word.equals(w.getWord()) & count == w.getCount();
    }

    public WordCount(Object word, Integer count) {
        this.word = (String) word;
        this.count = count;
    }

    public String getWord() {

        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
