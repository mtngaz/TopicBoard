package com.example.boardtopics.topicboard.entity;


import java.util.Date;

public class Message {
    private final Integer messageId;
    private final Integer topicId;
    private final String author;
    private final String text;
    private final Date date;

    public Message(Integer messageId, Integer topicId, String author, String text, Date date) {
        this.messageId = messageId;
        this.topicId = topicId;
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", topicId=" + topicId +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
