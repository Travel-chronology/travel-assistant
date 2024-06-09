package by.nexer.travelassistant.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TripDTO {
    private Long id;
    private String title;
    private String firstName;
    private String description;
    private String startDate;
    private String endDate;
    private Set<UserDTO> users;
}
