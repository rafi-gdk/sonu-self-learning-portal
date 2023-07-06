package com.sonu.tutorial.repository;

import com.sonu.tutorial.beans.entity.SubTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SubTopicsRepository extends JpaRepository<SubTopic, String> {

    List<SubTopic> findAllByTopicId(String topicId);

    SubTopic findBySubTopicId(String subTopicId);

    @Query(value = "SELECT sub.subTopicName FROM SubTopic sub")
    List<String> findAllSubTopics();

    @Query(value = "SELECT new com.sonu.tutorial.beans.entity.SubTopic(sub.subTopicId ,sub.topicId) FROM SubTopic sub WHERE sub.subTopicName =:subTopicName")
    List<SubTopic> findBySubTopicName(@Param("subTopicName") String subTopicName);

}