package com.dataht.event.model.view;

import com.dataht.event.model.jsonb.MediaWithUrl;
import com.dataht.event.model.presistence.Event;

import java.util.List;

public class PageEvent {
    private String id;

    private String title;

    private long time;

    private String summarize;

    private double influence;

    private double hot;

    private String picture;

    private List<MediaWithUrl> medias;

    public PageEvent() {
    }

    public PageEvent(Event event) {
        this.id = event.getUrlMd5();
        this.title = event.getTitle();
        this.time = event.getTime();
        this.summarize = event.getSummarize();
        this.influence = event.getInfluence();
        this.hot = event.getHot();
        this.medias = event.getMedia();
        this.picture = event.getPictureUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageEvent)) return false;

        PageEvent pageEvent = (PageEvent) o;

        if (time != pageEvent.time) return false;
        if (Double.compare(pageEvent.influence, influence) != 0) return false;
        if (Double.compare(pageEvent.hot, hot) != 0) return false;
        if (id != null ? !id.equals(pageEvent.id) : pageEvent.id != null) return false;
        if (title != null ? !title.equals(pageEvent.title) : pageEvent.title != null) return false;
        if (summarize != null ? !summarize.equals(pageEvent.summarize) : pageEvent.summarize != null) return false;
        if (picture != null ? !picture.equals(pageEvent.picture) : pageEvent.picture != null) return false;
        return medias != null ? medias.equals(pageEvent.medias) : pageEvent.medias == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (summarize != null ? summarize.hashCode() : 0);
        temp = Double.doubleToLongBits(influence);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hot);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (medias != null ? medias.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageEvent{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", summarize='" + summarize + '\'' +
                ", influence=" + influence +
                ", hot=" + hot +
                ", picture='" + picture + '\'' +
                ", medias=" + medias +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<MediaWithUrl> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaWithUrl> medias) {
        this.medias = medias;
    }
}
