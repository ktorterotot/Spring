package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;


@Service
public class TopicService {

//    private List<Topic> topics = new ArrayList<>(Arrays.asList(//This is a singleton meaning its only created once but used more than once
//            new Topic("Spring", "Spring Framework", "SpringFrameWork Description"),
//            new Topic("Java", "Core Java", "Core Java Description")
//    ));


    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic>topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(Long id) {
        return topicRepository.findOne(id);

    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Long id, Topic topic){
       topicRepository.save(topic);
    }

    public void deleteTopic(Long id){
      topicRepository.delete(id);

    }
}
