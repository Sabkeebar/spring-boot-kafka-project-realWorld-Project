package springbootkafkaproject.kafkaconsumerwikimedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import springbootkafkaproject.kafkaconsumerwikimedia.domain.Wikimedia;
import springbootkafkaproject.kafkaconsumerwikimedia.repository.WikimediaRepository;

@Service
public class ConsumerService {
    @Autowired
    WikimediaRepository wikimediaRepository;
  private   Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);
//  @Value("TopicConfig")
//  private  String topicName;

  @KafkaListener(topics = {"${spring.kafka.topicName1}"},groupId = "${spring.kafka.consumer.group-id}")
    public void receiver (@Payload String eventMessage){
      Wikimedia wikimedia = new Wikimedia(null,eventMessage);
      System.out.println(wikimedia);
      wikimediaRepository.save(wikimedia);
              LOGGER.info("event sent : "+eventMessage);

    }
}
