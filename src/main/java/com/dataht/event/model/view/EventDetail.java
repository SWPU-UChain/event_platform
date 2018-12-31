package com.dataht.event.model.view;

import com.dataht.event.model.jsonb.EventMetaEntity;
import com.dataht.event.model.jsonb.HotWithTime;
import com.dataht.event.model.jsonb.MediaWithUrl;
import com.dataht.event.model.jsonb.RelativeEvent;
import com.dataht.event.model.presistence.Event;

import java.util.List;

public class EventDetail {
    private String title;

    private String summarize;

    private double hot;

    private double influence;

    private Long time;

    private String type;

    private List<MediaWithUrl> medias;

    private List<RelativeEvent> relative;

    private EventMetaEntity eventMetaEntities;

    private List<HotWithTime> hotWithTimes;

    private List<String> label;

    public EventDetail() {
    }

    public EventDetail(Event event) {
        this(event.getTitle(), event.getSummarize(), event.getHot(), event.getInfluence(), event.getTime(),
                event.getType(), event.getMedia(), event.getRelative(),
                event.getEntity(), event.getHotWithTimes(),event.getLabel());
    }


    public EventDetail(String title, String summarize, double hot, double influence,
                       Long time, String type, List<MediaWithUrl> medias,
                       List<RelativeEvent> relative, EventMetaEntity eventMetaEntities,
                       List<HotWithTime> hotWithTimes,List<String> label) {
        this.title = title;
        this.summarize = summarize;
        this.hot = hot;
        this.influence = influence;
        this.time = time;
        this.type = type;
        this.medias = medias;
        this.relative = relative;
        this.eventMetaEntities = eventMetaEntities;
        this.hotWithTimes = hotWithTimes;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDetail that = (EventDetail) o;

        if (Double.compare(that.hot, hot) != 0) return false;
        if (Double.compare(that.influence, influence) != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (summarize != null ? !summarize.equals(that.summarize) : that.summarize != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (medias != null ? !medias.equals(that.medias) : that.medias != null) return false;
        if (relative != null ? !relative.equals(that.relative) : that.relative != null) return false;
        if (eventMetaEntities != null ? !eventMetaEntities.equals(that.eventMetaEntities) : that.eventMetaEntities != null)
            return false;
        if (hotWithTimes != null ? !hotWithTimes.equals(that.hotWithTimes) : that.hotWithTimes != null) return false;
        return label != null ? label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (summarize != null ? summarize.hashCode() : 0);
        temp = Double.doubleToLongBits(hot);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(influence);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (medias != null ? medias.hashCode() : 0);
        result = 31 * result + (relative != null ? relative.hashCode() : 0);
        result = 31 * result + (eventMetaEntities != null ? eventMetaEntities.hashCode() : 0);
        result = 31 * result + (hotWithTimes != null ? hotWithTimes.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventDetail{" +
                "title='" + title + '\'' +
                ", summarize='" + summarize + '\'' +
                ", hot=" + hot +
                ", influence=" + influence +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", medias=" + medias +
                ", relative=" + relative +
                ", eventMetaEntities=" + eventMetaEntities +
                ", hotWithTimes=" + hotWithTimes +
                ", label=" + label +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public double getHot() {
        return hot;
    }

    public void setHot(double hot) {
        this.hot = hot;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
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

    public List<MediaWithUrl> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaWithUrl> medias) {
        this.medias = medias;
    }

    public List<RelativeEvent> getRelative() {
        return relative;
    }

    public void setRelative(List<RelativeEvent> relative) {
        this.relative = relative;
    }

    public EventMetaEntity getEventMetaEntities() {
        return eventMetaEntities;
    }

    public void setEventMetaEntities(EventMetaEntity eventMetaEntities) {
        this.eventMetaEntities = eventMetaEntities;
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
}

