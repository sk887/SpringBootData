package springbootstarter.topic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import springbootstarter.topic.entity.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void addTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic,id);
    }


    @Service
    public static class TopicService {

        List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("as","dsfdfds","this is first topic"),
                new Topic("asa","dsfdfdsdd","this is second topic"),
                new Topic("asb","dsfdfdsbb","this is third topic")
        ));


        public List<Topic> getAllTopics(){
            return topics;
        }

        public Topic getTopic(String id){
            return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        }

        public void addTopic(Topic topic){
            topics.add(topic);
        }

        public void updateTopic(Topic topic, String id){
            for(int i =0 ;i< topics.size();i++){

                Topic t = topics.get(i);
                if(t.getId().equals(id)){
                    topics.set(i,topic);
                    return ;
                }
            }
        }
    }
}
