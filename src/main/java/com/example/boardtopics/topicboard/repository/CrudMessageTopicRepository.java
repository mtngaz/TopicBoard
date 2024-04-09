package com.example.boardtopics.topicboard.repository;

import com.example.boardtopics.topicboard.entity.Message;
import com.example.boardtopics.topicboard.entity.Topics;

import java.util.List;
import java.util.Optional;

public interface CrudMessageTopicRepository {
    public List<Topics> findAllTopics();
    void saveTopicIncMessage(String title, String author, String text);
    public Optional<Message> findMessageByTopicId(Integer topicId);
    public void saveMessage(String author, String text, Integer topicId);
    public int updateMessage(Message message);
    public int deleteMessage(Long topicId);
}
