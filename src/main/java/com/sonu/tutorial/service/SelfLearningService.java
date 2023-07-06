package com.sonu.tutorial.service;

import com.sonu.tutorial.beans.request.TopicRequest;
import com.sonu.tutorial.beans.response.SubTopicResponse;
import com.sonu.tutorial.beans.response.TopicResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface SelfLearningService {

    String addTopicUi(TopicRequest topics) throws IOException;

    List<TopicResponse> getAllTopics();

    List<SubTopicResponse> getSubTopics(String id);

    SubTopicResponse getContent(String subTopicId);

    List<String> getAllSubtopics();

    SubTopicResponse getSubtopicInfo(String subTopicName);
}
