package com.dataht.event.model.jsonb;

public class KeyWords {

    private String word;

    private String value;

    public KeyWords() {
    }

    @Override
    public String toString() {
        return "KeyWords{" +
                "word='" + word + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyWords)) return false;

        KeyWords keyWords = (KeyWords) o;

        if (word != null ? !word.equals(keyWords.word) : keyWords.word != null) return false;
        return value != null ? value.equals(keyWords.value) : keyWords.value == null;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
