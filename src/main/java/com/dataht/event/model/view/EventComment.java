package com.dataht.event.model.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventComment {
    private List<CommentEmotionCount> commentEmotionCounts;

    private List<WordCount> wordCounts;

    private List<CommentContent> commentContents;

    private List<DailyCommentCount> dailyCommentCounts;

    private List<CommentCount> commentCounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventComment that = (EventComment) o;

        if (commentEmotionCounts != null ? !commentEmotionCounts.equals(that.commentEmotionCounts) : that.commentEmotionCounts != null)
            return false;
        if (wordCounts != null ? !wordCounts.equals(that.wordCounts) : that.wordCounts != null) return false;
        if (commentContents != null ? !commentContents.equals(that.commentContents) : that.commentContents != null)
            return false;
        if (dailyCommentCounts != null ? !dailyCommentCounts.equals(that.dailyCommentCounts) : that.dailyCommentCounts != null)
            return false;
        return commentCounts != null ? commentCounts.equals(that.commentCounts) : that.commentCounts == null;
    }

    @Override
    public int hashCode() {
        int result = commentEmotionCounts != null ? commentEmotionCounts.hashCode() : 0;
        result = 31 * result + (wordCounts != null ? wordCounts.hashCode() : 0);
        result = 31 * result + (commentContents != null ? commentContents.hashCode() : 0);
        result = 31 * result + (dailyCommentCounts != null ? dailyCommentCounts.hashCode() : 0);
        result = 31 * result + (commentCounts != null ? commentCounts.hashCode() : 0);
        return result;
    }

    public EventComment() {
    }


    public EventComment(List<CommentEmotionCount> commentEmotionCounts, List<WordCount> wordCounts,
                        List<CommentContent> commentContents,
                        List<DailyCommentCount> dailyCommentCounts, List<CommentCount> commentCounts) {
        this.commentEmotionCounts = commentEmotionCounts;
        this.wordCounts = wordCounts;
        this.commentContents = commentContents;
        this.dailyCommentCounts = dailyCommentCounts;
        this.commentCounts = commentCounts;
        Collections.sort(commentEmotionCounts, Comparator.comparing(CommentEmotionCount::getType));
        Collections.sort(wordCounts, Comparator.comparing(WordCount::getWord).reversed());
        Collections.sort(dailyCommentCounts, Comparator.comparing(DailyCommentCount::getTime));
        Collections.sort(commentContents, Comparator.comparing(CommentContent::getType));
        Collections.sort(commentCounts, Comparator.comparing(CommentCount::getTime));
    }

    public List<CommentEmotionCount> getCommentEmotionCounts() {
        return commentEmotionCounts;
    }

    public void setCommentEmotionCounts(List<CommentEmotionCount> commentEmotionCounts) {
        this.commentEmotionCounts = commentEmotionCounts;
    }

    public List<WordCount> getWordCounts() {
        return wordCounts;
    }

    public void setWordCounts(List<WordCount> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public List<CommentContent> getCommentContents() {
        return commentContents;
    }

    public void setCommentContents(List<CommentContent> commentContents) {
        this.commentContents = commentContents;
    }

    public List<DailyCommentCount> getDailyCommentCounts() {
        return dailyCommentCounts;
    }

    public void setDailyCommentCounts(List<DailyCommentCount> dailyCommentCounts) {
        this.dailyCommentCounts = dailyCommentCounts;
    }

    public List<CommentCount> getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(List<CommentCount> commentCounts) {
        this.commentCounts = commentCounts;
    }

    @Override
    public String toString() {
        return "EventComment{" +
                "commentEmotionCounts=" + commentEmotionCounts +
                ", wordCounts=" + wordCounts +
                ", commentContents=" + commentContents +
                ", dailyCommentCounts=" + dailyCommentCounts +
                ", commentCounts=" + commentCounts +
                '}';
    }
}
