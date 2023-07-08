package springbootkafkaproject.kafkaproducerwikimedia.service;

import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import springbootkafkaproject.kafkaproducerwikimedia.helper.WikimediaChangesHandler;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    private static final Logger Logger = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    @Autowired
   private KafkaTemplate<String , String> kafkaTemplate ;
    @Value("${spring.kafka.topicName1}")
    private  String topic;
    public void sendMessage() throws InterruptedException {


        //to read real stream event from wikimedia
        WikimediaChangesHandler wikimediaChangesHandler =new WikimediaChangesHandler(kafkaTemplate,topic);
       String url ="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder =new EventSource.Builder(wikimediaChangesHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

            TimeUnit.MINUTES.sleep(10); // stop  after 10 minutes



    }


}
