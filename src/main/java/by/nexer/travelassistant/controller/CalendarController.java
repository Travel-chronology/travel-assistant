package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.messaging.event.TripSendEvent;
import by.nexer.travelassistant.messaging.producer.KafkaMessagingProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final KafkaMessagingProducer kafkaMessagingProducer;

    @PostMapping("/event")
    public void createEvent(@RequestParam String summary, @RequestParam String description,
                            @RequestParam  String startDate,
                            @RequestParam String endDate) throws Exception {

        TripSendEvent tripSendEvent = new TripSendEvent();
        tripSendEvent.setDescription(description);
        tripSendEvent.setSummary(summary);
        tripSendEvent.setStartDate(startDate);
        tripSendEvent.setEndDate(endDate);

        log.info("Send trip to kafka");
        kafkaMessagingProducer.sendTrip(tripSendEvent);
    }
}
