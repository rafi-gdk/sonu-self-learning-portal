package com.sonu.tutorial.beans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUB_TOPIC")
public class SubTopic implements Serializable {

    @Id
    @GeneratedValue(generator = "gen_uuid")
    @GenericGenerator(name = "gen_uuid", strategy = "uuid2")
    @Column(name = "SUB_TOPIC_ID")
    private String subTopicId;
    @Column(name = "TOPIC_ID")
    private String topicId;
    @Column(name = "SUB_TOPIC_NAME")
    private String subTopicName;
    @Column(name = "SUB_TOPIC_CONTENT", columnDefinition = "TEXT")
    private String subTopicContent;
    @Lob
    @Column(name = "IMAGES", length = Integer.MAX_VALUE, nullable = true)
    @Basic(fetch = FetchType.LAZY, optional = true)
    private byte[] image;

    public SubTopic(String subTopicName) {
        this.subTopicName = subTopicName;
    }

    public SubTopic(String subTopicId, String topicId) {
        this.subTopicId = subTopicId;
        this.topicId = topicId;
    }
}