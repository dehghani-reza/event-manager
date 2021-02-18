package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.dto.user.UserForProfileDTO;
import ir.team.eventmanager.exceptions.user.UserNotFoundException;
import ir.team.eventmanager.services.user.LoadUserByIdService;
import ir.team.eventmanager.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadUserByIdController extends UserController{

    private final LoadUserByIdService service;

    @Autowired
    public LoadUserByIdController(LoadUserByIdService service) {
        this.service = service;
    }


    @GetMapping(value = "/load-user/{id}")
    public UserForProfileDTO loadUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
        User user = service.loadUserById(userId);
        return new UserForProfileDTO(user.getUsername(),
                Tools.nvl(user.getEmail(),""),
                user.getIsEnable(),
                user.getRole().name());
    }
}
