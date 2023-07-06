package com.sonu.tutorial.beans.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TopicRequest {

    private String topicName;
    private String subTopicName;
    private String content;
    private MultipartFile image;

}
