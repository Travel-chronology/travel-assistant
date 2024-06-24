package by.nexer.travelassistant.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripSendEvent {
    private String summary;
    private String description;
    private String startDate;
    private String endDate;
}