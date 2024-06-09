package by.nexer.travelassistant.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private Set<TripDTO> users;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
