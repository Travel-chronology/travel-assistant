package by.nexer.travelassistant.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEmailSendEvent {
    private String email;
    private String title;
    private String message;
}