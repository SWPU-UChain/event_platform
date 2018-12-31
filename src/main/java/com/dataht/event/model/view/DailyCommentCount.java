package com.dataht.event.model.view;

public class DailyCommentCount {

    private long time;

    private int count;

    public DailyCommentCount() {
    }

    public DailyCommentCount(Long time, int count) {
        this.time = time;
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DailyCommentCount))
            return false;

        DailyCommentCount d = (DailyCommentCount) obj;
        return (time == d.getTime()) & (count == d.getCount());
    }

    public long getTime() {

        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DailyCommentCount{" +
                "time=" + time +
                ", count=" + count +
                '}';
    }
}
