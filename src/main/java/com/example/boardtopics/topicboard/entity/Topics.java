package com.example.boardtopics.topicboard.entity;

public class Topics {
    private final Integer topicId;
    private final String title;

    public Topics(Integer topicId, String topicTitle) {
        this.topicId = topicId;
        this.title = topicTitle;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }
}
