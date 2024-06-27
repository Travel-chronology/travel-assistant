package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.messaging.event.NotificationEmailSendEvent;
import by.nexer.travelassistant.messaging.event.TripSendEvent;
import by.nexer.travelassistant.messaging.producer.NotificationMessagingProducer;
import by.nexer.travelassistant.messaging.producer.TripMessagingProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationMessagingProducer kafkaMessagingProducer;

    @Operation(
            summary = "Send email Async",
            description = "Send email Async via kafka")
    @PostMapping("/email")
    public void createEvent(@RequestParam String email, @RequestParam String title,@RequestParam String message) throws Exception {

        NotificationEmailSendEvent notificationEmailSendEvent = new NotificationEmailSendEvent();
        notificationEmailSendEvent.setEmail(email);
        notificationEmailSendEvent.setTitle(title);
        notificationEmailSendEvent.setMessage(message);

        log.info("Send email event to kafka");
        kafkaMessagingProducer.sentEmail(notificationEmailSendEvent);
    }
}
