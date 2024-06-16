package by.nexer.travelassistant.dto.response;

import by.nexer.travelassistant.dto.response.UserResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class TripResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<UserResponse> users;
}
