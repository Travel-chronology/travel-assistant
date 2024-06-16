package by.nexer.travelassistant.dto;

import by.nexer.travelassistant.model.entity.TripEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class UserDTO {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}
