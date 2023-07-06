package com.sonu.tutorial.beans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @GeneratedValue(generator = "gen_uuid")
    @GenericGenerator(name = "gen_uuid", strategy = "uuid2")
    @Column(name = "TOPIC_ID")
    private String topicId;
    @Column(name = "TOPIC_NAME")
    private String topicName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TOPIC_ID", referencedColumnName = "TOPIC_ID")
    private List<SubTopic> subTopics;
}
