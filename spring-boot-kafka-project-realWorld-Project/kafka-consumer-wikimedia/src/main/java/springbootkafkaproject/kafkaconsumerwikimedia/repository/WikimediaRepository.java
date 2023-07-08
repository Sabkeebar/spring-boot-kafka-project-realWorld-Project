package springbootkafkaproject.kafkaconsumerwikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootkafkaproject.kafkaconsumerwikimedia.domain.Wikimedia;

public interface WikimediaRepository  extends JpaRepository<Wikimedia,Long> {
}
