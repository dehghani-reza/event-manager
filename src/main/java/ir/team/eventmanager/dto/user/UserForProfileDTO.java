package ir.team.eventmanager.dto.user;

import ir.team.eventmanager.domain.Role;
import lombok.Value;

@Value
public class UserForProfileDTO {

    private String username;
    private String email;
    private Boolean isEnable;
    private String role;
}
