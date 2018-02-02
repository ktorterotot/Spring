package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //The purpose of the controller is so that we can map our endpoints
public class TopicController {

    @Autowired//Tell spring to inject the singleton
    private TopicService topicService; //instance variable

    @RequestMapping("/topics")
    public List<Topic>getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")//Post is making a new post to your postman
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")//Put is you wanting to change what's already there
        public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
        public void deleteTopic(@PathVariable Long id){
            topicService.deleteTopic(id);
        }
    }


