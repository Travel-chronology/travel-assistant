package by.nexer.travelassistant.messaging.producer;

import by.nexer.travelassistant.messaging.event.NotificationEmailSendEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationMessagingProducer {

    @Value("${topic.send-notification-email}")
    private String sendClientTopic;

    private final KafkaTemplate<String , Object> kafkaTemplate;

    public void sentEmail(NotificationEmailSendEvent notificationEmailSendEvent) {
        kafkaTemplate.send(sendClientTopic,  notificationEmailSendEvent);
    }
}
