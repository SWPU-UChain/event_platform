package com.dataht.event.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "event.service")
public class CountProperties {

    private int pageCount;
    private int relativeCount;
    private int commentCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRelativeCount() {
        return relativeCount;
    }

    public void setRelativeCount(int relativeCount) {
        this.relativeCount = relativeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
