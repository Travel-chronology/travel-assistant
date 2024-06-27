package by.nexer.travelassistant.controller;

import by.nexer.travelassistant.messaging.event.TripSendEvent;
import by.nexer.travelassistant.messaging.producer.TripMessagingProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final TripMessagingProducer kafkaMessagingProducer;

    @Operation(
            summary = "Send trip Async",
            description = "Send trip Async in google calendar via kafka")
    @PostMapping("/event")
    public void createEvent(@RequestParam String summary, @RequestParam String description,
                            @RequestParam
                            @Parameter(description = "Format yyyy-MM-dd'T'HH:mm", example = "2024-06-26T10:00:00")
                            String startDate,
                            @RequestParam
                            @Parameter(description = "Format yyyy-MM-dd'T'HH:mm", example = "2024-06-27T10:00:00")
                            String endDate) throws Exception {

        TripSendEvent tripSendEvent = new TripSendEvent();
        tripSendEvent.setDescription(description);
        tripSendEvent.setSummary(summary);
        tripSendEvent.setStartDate(startDate);
        tripSendEvent.setEndDate(endDate);

        log.info("Send trip to kafka");
        kafkaMessagingProducer.sendTrip(tripSendEvent);
    }
}
