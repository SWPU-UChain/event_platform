package com.dataht.event.model.presistence;

import com.dataht.event.converter.*;
import com.dataht.event.model.jsonb.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = TABLE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "url_md5")
    private String urlMd5;
    private String title;
    @Convert(converter = TimestampLongConverter.class)
    private Long time;
    private String type;
    @Column(name = "keywords")
    @Convert(converter = KeyWordsConverter.class)
    private List<KeyWords> keywords;
    private double influence;
    @Column(name = "hot")
    private double hot;
    private String summarize;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Column(name = "media")
    @Convert(converter = MediaWithUrlListConverter.class)
    private List<MediaWithUrl> media;
    @Column(name = "relative_event")
    @Convert(converter = RelativeEventListConverter.class)
    private List<RelativeEvent> relative;
    @Convert(converter = EventMetaEntityConverter.class)
    private EventMetaEntity entity;
    @Column(name = "hot_with_time")
    @Convert(converter = HotWithTimeListConverter.class)
    private List<HotWithTime> hotWithTimes;
    @Convert(converter = StringListConverter.class)
    private List<String> label;
    private String website;

    public Event() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (Double.compare(event.influence, influence) != 0) return false;
        if (Double.compare(event.hot, hot) != 0) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (urlMd5 != null ? !urlMd5.equals(event.urlMd5) : event.urlMd5 != null) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        if (time != null ? !time.equals(event.time) : event.time != null) return false;
        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (keywords != null ? !keywords.equals(event.keywords) : event.keywords != null) return false;
        if (summarize != null ? !summarize.equals(event.summarize) : event.summarize != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(event.pictureUrl) : event.pictureUrl != null) return false;
        if (media != null ? !media.equals(event.media) : event.media != null) return false;
        if (relative != null ? !relative.equals(event.relative) : event.relative != null) return false;
        if (entity != null ? !entity.equals(event.entity) : event.entity != null) return false;
        if (hotWithTimes != null ? !hotWithTimes.equals(event.hotWithTimes) : event.hotWithTimes != null) return false;
        if (label != null ? !label.equals(event.label) : event.label != null) return false;
        return website != null ? website.equals(event.website) : event.website == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (urlMd5 != null ? urlMd5.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        temp = Double.doubleToLongBits(influence);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hot);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (summarize != null ? summarize.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + (relative != null ? relative.hashCode() : 0);
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        result = 31 * result + (hotWithTimes != null ? hotWithTimes.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", urlMd5='" + urlMd5 + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", keywords=" + keywords +
                ", influence=" + influence +
                ", hot=" + hot +
                ", summarize='" + summarize + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", media=" + media +
                ", relative=" + relative +
                ", entity=" + entity +
                ", hotWithTimes=" + hotWithTimes +
                ", label=" + label +
                ", website='" + website + '\'' +
                '}';
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<KeyWords> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<KeyWords> keywords) {
        this.keywords = keywords;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
    }

    public double getHot() {
        return hot;
    }

    public void setHot(double hot) {
        this.hot = hot;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<MediaWithUrl> getMedia() {
        return media;
    }

    public void setMedia(List<MediaWithUrl> media) {
        this.media = media;
    }

    public List<RelativeEvent> getRelative() {
        return relative;
    }

    public void setRelative(List<RelativeEvent> relative) {
        this.relative = relative;
    }

    public EventMetaEntity getEntity() {
        return entity;
    }

    public void setEntity(EventMetaEntity entity) {
        this.entity = entity;
    }

    public List<HotWithTime> getHotWithTimes() {
        return hotWithTimes;
    }

    public void setHotWithTimes(List<HotWithTime> hotWithTimes) {
        this.hotWithTimes = hotWithTimes;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
