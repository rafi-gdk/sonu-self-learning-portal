package com.sonu.tutorial.beans.response;

import com.sonu.tutorial.beans.entity.SubTopic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicResponse {

    private String topicId;
    private String topicName;
    private List<SubTopic> subTopics;
}
