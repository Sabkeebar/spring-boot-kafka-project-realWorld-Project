package springbootkafkaproject.kafkaconsumerwikimedia.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wikimedia {
    @Id
    @GeneratedValue
   private Long id;
  @Lob
    private  String eventMessage;


}
