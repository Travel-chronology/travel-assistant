package by.nexer.travelassistant.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class TripDTO {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<UserDTO> users;
}
