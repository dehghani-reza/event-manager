package ir.team.eventmanager.dto.user;

import lombok.Value;

@Value
public class CreateUserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long dateOfBirth;

}
