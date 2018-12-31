package com.dataht.event.model.view;

public class CommentEmotionCount {
    private String type;

    private int count;

    public CommentEmotionCount() {
    }

    public CommentEmotionCount(Object type, Integer count) {
        this.type = (String) type;
        this.count = count;
    }

    public CommentEmotionCount(String type, Long count) {
        this.type = type;
        this.count = count.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CommentEmotionCount))
            return false;

        CommentEmotionCount c = (CommentEmotionCount) obj;
        return type.equals(c.getType()) & (count == c.getCount());
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommentEmotionCount{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
