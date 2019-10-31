package springbootstarter.topic.dao;

import org.springframework.data.repository.CrudRepository;
import springbootstarter.topic.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
