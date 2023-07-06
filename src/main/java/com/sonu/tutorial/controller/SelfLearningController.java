package com.sonu.tutorial.controller;


import com.sonu.tutorial.beans.request.TopicRequest;
import com.sonu.tutorial.beans.response.SubTopicResponse;
import com.sonu.tutorial.beans.response.TopicResponse;
import com.sonu.tutorial.service.SelfLearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SelfLearningController {

    @Autowired
    SelfLearningService selfLearningService;

    @PostMapping(value = "/add-topic-ui", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addTopicUi(TopicRequest topics) throws IOException {
        System.out.println("SelfLearningController.addTopicUi--"+topics);
        topics.setContent(topics.getContent().replace(" ", "&nbsp;"));
        return new ResponseEntity<>(selfLearningService.addTopicUi(topics), HttpStatus.ACCEPTED);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<TopicResponse>> getAllTopics() {
        return new ResponseEntity<>(selfLearningService.getAllTopics(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<List<SubTopicResponse>> getSubTopics(@PathVariable String topicId) {
        return new ResponseEntity<>(selfLearningService.getSubTopics(topicId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/subtopics/{subTopicId}")
    public ResponseEntity<SubTopicResponse> getContent(@PathVariable String subTopicId) {
        return new ResponseEntity<>(selfLearningService.getContent(subTopicId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/sub-topics")
    public ResponseEntity<List<String>> getAllSubtopics() {
        //List<SubTopicResponse> allSubtopics = selfLearningService.getAllSubtopics();
        //List<String> list = allSubtopics.stream().map(i -> i.getSubTopicName()).toList();
        return new ResponseEntity<>(selfLearningService.getAllSubtopics(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/subtopics/{subTopicName}")
    public ResponseEntity<SubTopicResponse> getSubtopicInfo(@PathVariable String subTopicName) {
        return new ResponseEntity<>(selfLearningService.getSubtopicInfo(subTopicName), HttpStatus.ACCEPTED);
    }

}
