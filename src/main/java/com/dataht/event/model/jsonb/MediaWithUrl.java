package com.dataht.event.model.jsonb;


public class MediaWithUrl {

    private String media;
    private String url_md5;

    public MediaWithUrl() {
    }

    @Override
    public String toString() {
        return "MediaWithUrl{" +
                "media='" + media + '\'' +
                ", url_md5='" + url_md5 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MediaWithUrl)) return false;

        MediaWithUrl that = (MediaWithUrl) o;

        if (media != null ? !media.equals(that.media) : that.media != null) return false;
        return url_md5 != null ? url_md5.equals(that.url_md5) : that.url_md5 == null;
    }

    @Override
    public int hashCode() {
        int result = media != null ? media.hashCode() : 0;
        result = 31 * result + (url_md5 != null ? url_md5.hashCode() : 0);
        return result;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getUrl_md5() {
        return url_md5;
    }

    public void setUrl_md5(String url_md5) {
        this.url_md5 = url_md5;
    }
}
