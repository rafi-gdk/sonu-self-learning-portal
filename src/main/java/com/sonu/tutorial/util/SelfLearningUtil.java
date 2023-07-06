package com.sonu.tutorial.util;

import com.sonu.tutorial.beans.entity.SubTopic;
import com.sonu.tutorial.beans.entity.Topic;
import com.sonu.tutorial.beans.response.SubTopicResponse;
import com.sonu.tutorial.beans.response.TopicResponse;
import com.sonu.tutorial.mapper.SelfLearningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SelfLearningUtil {

    @Autowired
    SelfLearningMapper mapper;

    public TopicResponse buildTopicResponse(Topic topics) {
        TopicResponse topicResponse = mapper.prepareTopicResponse(topics);
        return topicResponse;
    }

    public SubTopicResponse buildSubTopicResponse(SubTopic subTopics) {
        SubTopicResponse subTopicResponse = SubTopicResponse.builder()
                .subTopicId(subTopics.getSubTopicId())
                .topicId(subTopics.getTopicId())
                .subTopicName(subTopics.getSubTopicName())
                .subTopicContent(subTopics.getSubTopicContent())
                .image(ImageUtil.decompressImage(subTopics.getImage()))
                .build();
        return subTopicResponse;
    }
}

