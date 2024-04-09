package com.example.boardtopics.topicboard.controllers;

import com.example.boardtopics.topicboard.entity.Message;
import com.example.boardtopics.topicboard.entity.Topics;
import com.example.boardtopics.topicboard.repository.CrudMessageTopicRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/topicBoard")
public class TopicBoardController {
    private CrudMessageTopicRepository repository;

    public TopicBoardController(CrudMessageTopicRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/topic")
    public List<Topics> findAllTopics() {
        return repository.findAllTopics();
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> findMessageByTopicId(@PathVariable Integer id) {
        if (repository.findMessageByTopicId(id).isEmpty()) {
            return ResponseEntity.status(404).body("Сообщение не найдено");
        }
        return ResponseEntity.ok(repository.findMessageByTopicId(id));
    }

    @PostMapping("/topic/message")
    public ResponseEntity<String> saveTopicIncMessage(@RequestParam("title") String tittle,
                                              @RequestParam("author") String author,
                                              @RequestParam("text") String text) {
        repository.saveTopicIncMessage(tittle, author, text);
        return ResponseEntity.ok("Сохранение прошло успешно");
    }

    @PostMapping("/message")
    public ResponseEntity<String> saveMessage(@RequestParam("author") String author,
                            @RequestParam("text") String text,
                            @RequestParam("id") Integer topicId) {
        repository.saveMessage(author, text, topicId);
        return ResponseEntity.ok("Сохранение прошло успешно");
    }

    @PutMapping("/message")
    public ResponseEntity<String> updateMessage(@RequestBody Message message) {
        int update = repository.updateMessage(message);
        if (update == 1) {
            return ResponseEntity.ok("Изменение прошло успешно");
        } else {
            return ResponseEntity.status(404).body("Сообщение не найдено");
        }
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id) {
        int update = repository.deleteMessage(id);
        if (update == 1) {
            return ResponseEntity.ok("Удаление прошло успешно");
        } else {
            return ResponseEntity.status(404).body("Сообщение не найдено");
        }
    }
}
