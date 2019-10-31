package springbootstarter.topic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstarter.topic.dao.TopicRepository;
import springbootstarter.topic.entity.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicServiceImpl {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("as","dsfdfds","this is first topic"),
            new Topic("asa","dsfdfdsdd","this is second topic"),
            new Topic("asb","dsfdfdsbb","this is third topic")
    ));


    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);

        return topics;

    }

    public Topic getTopic(String id){
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(Topic topic){
        //topics.add(topic);

        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        //for(int i =0 ;i< topics.size();i++){
        //  Topic t = topics.get(i);
        // if(t.getId().equals(id)){
        //    topics.set(i,topic);
        //   return ;
        //}
        //}
        topicRepository.save(topic);
    }
}
