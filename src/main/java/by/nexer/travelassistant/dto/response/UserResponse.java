package by.nexer.travelassistant.dto.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponse {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}
