package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.dto.user.UserForProfileDTO;
import ir.team.eventmanager.exceptions.user.UserNotFoundException;
import ir.team.eventmanager.services.user.ActiveUserByManager;
import ir.team.eventmanager.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveUserByManagerController extends UserController{

    private final ActiveUserByManager service;

    @Autowired
    public ActiveUserByManagerController(ActiveUserByManager service) {
        this.service = service;
    }

    @PostMapping(value = "/active-user")
    public UserForProfileDTO activeUserByManager(@RequestBody Long id) throws UserNotFoundException {
        User user = service.activeUserByManagerWithId(id);
        return new UserForProfileDTO(user.getUsername(),
                Tools.nvl(user.getEmail(),""),
                user.getIsEnable(),
                user.getRole().name());
    }
}
