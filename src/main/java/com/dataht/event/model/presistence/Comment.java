package com.dataht.event.model.presistence;

import com.dataht.event.converter.StringListConverter;
import com.dataht.event.converter.TimestampLongConverter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = TABLE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "url_md5")
    private String urlMd5;
    private String content;
    @Convert(converter = TimestampLongConverter.class)
    private Long time;
    @Column(name = "word")
    @Convert(converter = StringListConverter.class)
    private List<String> words;
    private String type;
    @Column(name = "emotion_rsi")
    private double emotionRsi;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", urlMd5='" + urlMd5 + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", words=" + words +
                ", type='" + type + '\'' +
                ", emotionRsi=" + emotionRsi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (Double.compare(comment.emotionRsi, emotionRsi) != 0) return false;
        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (urlMd5 != null ? !urlMd5.equals(comment.urlMd5) : comment.urlMd5 != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (time != null ? !time.equals(comment.time) : comment.time != null) return false;
        if (words != null ? !words.equals(comment.words) : comment.words != null) return false;
        return type != null ? type.equals(comment.type) : comment.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (urlMd5 != null ? urlMd5.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (words != null ? words.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(emotionRsi);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlMd5() {
        return urlMd5;
    }

    public void setUrlMd5(String urlMd5) {
        this.urlMd5 = urlMd5;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEmotionRsi() {
        return emotionRsi;
    }

    public void setEmotionRsi(double emotionRsi) {
        this.emotionRsi = emotionRsi;
    }
}
