package com.sonu.tutorial.repository;


import com.sonu.tutorial.beans.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TopicsRepository extends JpaRepository<Topic, String> {
    Topic findByTopicName(String topicName);
}
