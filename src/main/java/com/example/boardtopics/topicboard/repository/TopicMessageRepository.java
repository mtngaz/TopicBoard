package com.example.boardtopics.topicboard.repository;

import com.example.boardtopics.topicboard.entity.Message;
import com.example.boardtopics.topicboard.entity.Topics;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TopicMessageRepository implements CrudMessageTopicRepository {
    private JdbcTemplate jdbcTemplate;

    public TopicMessageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Topics> findAllTopics() {
        String sql = "SELECT * FROM topics";
        RowMapper<Topics> topicsRowMapper = (rs, rowNum) -> new Topics(rs.getInt("topicId"), rs.getString("title"));
        return jdbcTemplate.query(sql, topicsRowMapper);
    }

    @Override
    public void saveTopicIncMessage(String title, String author, String text) {
        String sql = "INSERT INTO topics (title) VALUES (?)";
        jdbcTemplate.update(sql, title);
        saveMessage(author, text, findAllTopics().size());
    }

    @Override
    public Optional<Message> findMessageByTopicId(Integer topicId) {
        String sql = "SELECT * FROM message WHERE topicId = ?";
        RowMapper<Message> rowMapper = (rs, rowNum) -> new Message(rs.getInt(1),
                rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5));
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, rowMapper, topicId));
    }

    @Override
    public void saveMessage(String author, String text, Integer topicId) {
        String sql = "INSERT INTO message (topicId, author, text) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, topicId, author, text);
    }

    @Override
    public int updateMessage(Message message) {
        String sql = "UPDATE message SET author = ?, text = ? WHERE topicId = ?";
        return jdbcTemplate.update(sql, message.getAuthor(), message.getText(), message.getTopicId());
    }

    @Override
    public int deleteMessage(Long topicId) {
        String sql = "DELETE FROM message WHERE topicId = ?";
        return jdbcTemplate.update(sql, topicId);
    }
}
