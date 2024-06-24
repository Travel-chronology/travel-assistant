package by.nexer.travelassistant.messaging.producer;

import by.nexer.travelassistant.messaging.event.TripSendEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessagingProducer {

    @Value("${topic.send-google-calendar}")
    private String sendClientTopic;

    private final KafkaTemplate<String , Object> kafkaTemplate;

    public void sendTrip(TripSendEvent tripSendEvent) {
        kafkaTemplate.send(sendClientTopic,  tripSendEvent);
    }
}
