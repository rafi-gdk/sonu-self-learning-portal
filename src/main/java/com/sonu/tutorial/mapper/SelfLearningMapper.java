package com.sonu.tutorial.mapper;

import com.sonu.tutorial.beans.entity.SubTopic;
import com.sonu.tutorial.beans.entity.Topic;
import com.sonu.tutorial.beans.response.SubTopicResponse;
import com.sonu.tutorial.beans.response.TopicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SelfLearningMapper {

    @Mapping(target = "subTopics", source = "subTopics")
    TopicResponse prepareTopicResponse(Topic topics);

    SubTopicResponse prepareSubTopicResponse(SubTopic subTopics);

}

