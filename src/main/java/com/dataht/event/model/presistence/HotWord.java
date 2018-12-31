package com.dataht.event.model.presistence;

import com.dataht.event.converter.StringListConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "hot_words")
public class HotWord {

    @Id
    @GeneratedValue(strategy = TABLE)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Convert(converter = StringListConverter.class)
    private List<String> words;

    public HotWord() {
    }

    @Override
    public String toString() {
        return "HotWord{" +
                "id=" + id +
                ", time=" + time +
                ", words=" + words +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotWord hotWord = (HotWord) o;

        if (id != null ? !id.equals(hotWord.id) : hotWord.id != null) return false;
        if (time != null ? !time.equals(hotWord.time) : hotWord.time != null) return false;
        return words != null ? words.equals(hotWord.words) : hotWord.words == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (words != null ? words.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
