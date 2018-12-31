package com.dataht.event.model.jsonb;


public class HotWithTime {

    private Long time;
    private Double hot;

    public HotWithTime() {
    }

    @Override
    public String toString() {
        return "HotWithTime{" +
                "time=" + time +
                ", hot=" + hot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotWithTime that = (HotWithTime) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return hot != null ? hot.equals(that.hot) : that.hot == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (hot != null ? hot.hashCode() : 0);
        return result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getHot() {
        return hot;
    }

    public void setHot(Double hot) {
        this.hot = hot;
    }
}
