package com.dataht.event.model.view;

import java.util.List;

public class CommentContent {

    private String type;

    private List<String> comments;

    public CommentContent() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CommentContent))
            return false;

        CommentContent c = (CommentContent) obj;
        return type.equals(c.getType()) & comments.equals(c.getComments());
    }

    public CommentContent(String type, List<String> comments) {

        this.type = type;
        this.comments = comments;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CommentContent{" +
                "type='" + type + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
