package springbootkafkaproject.kafkaproducerwikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import springbootkafkaproject.kafkaproducerwikimedia.helper.WikimediaChangesHandler;
import springbootkafkaproject.kafkaproducerwikimedia.service.WikimediaChangesProducer;

@SpringBootApplication
@EnableKafka
public class KafkaProducerWikimediaApplication implements CommandLineRunner {
@Autowired
    WikimediaChangesProducer wikimediaChangesProducer;
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();

    }
}
