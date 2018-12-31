package com.dataht.event.model.jsonb;

public class RelativeEvent {
    private String title;
    private String url_md5;
    private double value;

    public RelativeEvent() {
    }

    public RelativeEvent(String title, String url_md5, double value) {
        this.title = title;
        this.url_md5 = url_md5;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelativeEvent)) return false;

        RelativeEvent that = (RelativeEvent) o;

        if (Double.compare(that.value, value) != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return url_md5 != null ? url_md5.equals(that.url_md5) : that.url_md5 == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url_md5 != null ? url_md5.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_md5() {
        return url_md5;
    }

    public void setUrl_md5(String url_md5) {
        this.url_md5 = url_md5;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
