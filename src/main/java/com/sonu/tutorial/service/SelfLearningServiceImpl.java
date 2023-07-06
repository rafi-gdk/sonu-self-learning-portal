package com.sonu.tutorial.service;

import com.sonu.tutorial.beans.entity.SubTopic;
import com.sonu.tutorial.beans.entity.Topic;
import com.sonu.tutorial.beans.request.TopicRequest;
import com.sonu.tutorial.beans.response.SubTopicResponse;
import com.sonu.tutorial.beans.response.TopicResponse;
import com.sonu.tutorial.repository.SubTopicsRepository;
import com.sonu.tutorial.repository.TopicsRepository;
import com.sonu.tutorial.util.ImageUtil;
import com.sonu.tutorial.util.SelfLearningUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SelfLearningServiceImpl implements SelfLearningService {

    @Autowired
    TopicsRepository repository;

    @Autowired
    SubTopicsRepository subTopicsRepository;

    @Autowired
    SelfLearningUtil util;

    @Transactional
    @Override
    public String addTopicUi(TopicRequest topics) throws IOException {

        topics.setTopicName(StringUtils.capitalize(topics.getTopicName().trim()));
        topics.setSubTopicName(StringUtils.capitalize(topics.getSubTopicName().trim()));

        Topic byTopicName = repository.findByTopicName(topics.getTopicName());
        if (null != byTopicName) {
            List<SubTopic> list = byTopicName.getSubTopics().stream().filter(i -> i.getSubTopicName().equalsIgnoreCase(topics.getSubTopicName())).toList();
            if (!list.isEmpty()) {
                SubTopic subTopic = list.get(0);
                subTopic.setSubTopicContent(topics.getContent());
                SubTopic save = subTopicsRepository.save(subTopic);
                if (save.getSubTopicId().equalsIgnoreCase(subTopic.getTopicId())) {
                    throw new RuntimeException();
                }
            } else {
                SubTopic subTopic = new SubTopic();
                subTopic.setTopicId(byTopicName.getTopicId());
                subTopic.setSubTopicName(topics.getSubTopicName());
                subTopic.setSubTopicContent(topics.getContent());
                subTopicsRepository.save(subTopic);
            }
        } else {
            List<SubTopic> list1 = new ArrayList<>();
            list1.add(new SubTopic(null, null, topics.getSubTopicName(), topics.getContent(), ImageUtil.compressImage(topics.getImage() != null ? topics.getImage().getBytes() : null)));
            Topic topic = new Topic();
            topic.setSubTopics(list1);
            topic.setTopicName(topics.getTopicName());
            repository.save(topic);
        }

        return "Success";
    }

    @Transactional
    @Override
    public List<TopicResponse> getAllTopics() {
        List<TopicResponse> topicResponseList = null;
        try {
            List<Topic> customers = repository.findAll();
            topicResponseList = customers.stream().map(i -> util.buildTopicResponse(i)).sorted(Comparator.comparing(TopicResponse::getTopicName)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            e.printStackTrace();
        }
        return topicResponseList;
    }

    @Transactional
    @Override
    public List<SubTopicResponse> getSubTopics(String id) {
        List<SubTopicResponse> topicResponseList = null;
        try {
            List<SubTopic> allById = subTopicsRepository.findAllByTopicId(id);
            topicResponseList = allById.stream().map(i -> util.buildSubTopicResponse(i)).sorted(Comparator.comparing(SubTopicResponse::getSubTopicName)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            e.printStackTrace();
        }
        return topicResponseList;
    }

    @Transactional
    @Override
    public SubTopicResponse getContent(String subTopicId) {
        SubTopicResponse topicResponseList = null;
        try {
            SubTopic bySubTopicId = subTopicsRepository.findBySubTopicId(subTopicId);
            topicResponseList = util.buildSubTopicResponse(bySubTopicId);
            String subTopicContent = topicResponseList.getSubTopicContent();
            String[] split = subTopicContent.split("<br/>");
            for (String s : split) {
                if (s.contains(":-")) {
                    int index = s.indexOf(":-") + 1;
                    String substring = s.substring(0, index).trim();
                    String rearranged = "<u>" + substring + "</u>";
                    subTopicContent = subTopicContent.replace(substring, rearranged);
                }
            }
            if (subTopicContent.startsWith("<br/>")) {
                subTopicContent = subTopicContent.substring(5);
            }
            subTopicContent = "<p>" + subTopicContent + "</p>";
            topicResponseList.setSubTopicContent(subTopicContent);
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            e.printStackTrace();
        }
        return topicResponseList;
    }

    @Override
    public List<String> getAllSubtopics() {
        List<String> topicResponseList = null;
        try {
            topicResponseList = subTopicsRepository.findAllSubTopics();
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            e.printStackTrace();
        }
        return topicResponseList;
    }

    @Override
    public SubTopicResponse getSubtopicInfo(String subTopicName) {

        SubTopicResponse topicResponseList = null;
        try {
            List<SubTopic> bySubTopicName = subTopicsRepository.findBySubTopicName(subTopicName);
            System.out.println(bySubTopicName);
            SubTopic subTopic = bySubTopicName.size() > 0 ? bySubTopicName.get(0) : null;
            topicResponseList = util.buildSubTopicResponse(subTopic);
        } catch (Exception e) {
            log.error("Exception Occurred in getAllCustomers: " + e);
            e.printStackTrace();
        }
        return topicResponseList;
    }
}
