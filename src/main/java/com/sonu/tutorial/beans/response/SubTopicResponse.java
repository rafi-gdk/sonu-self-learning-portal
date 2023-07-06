package com.sonu.tutorial.beans.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SubTopicResponse {

    private String subTopicId;
    private String topicId;
    private String subTopicName;
    private String subTopicContent;
    private byte[] image;

    public SubTopicResponse(String subTopicId, String topicId) {
        this.subTopicId = subTopicId;
        this.topicId = topicId;
    }
}