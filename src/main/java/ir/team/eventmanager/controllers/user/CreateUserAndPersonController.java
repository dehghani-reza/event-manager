package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.dto.user.CreateUserDTO;
import ir.team.eventmanager.exceptions.user.CreateUserException;
import ir.team.eventmanager.services.user.CreateUserAndPersonByManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserAndPersonController extends UserController{

    private final CreateUserAndPersonByManager service;

    @Autowired
    public CreateUserAndPersonController(CreateUserAndPersonByManager service) {
        this.service = service;
    }

    @PostMapping(value = "/create-user-and-person")
    public boolean createUserAndPerson(@RequestBody CreateUserDTO userDTO) throws CreateUserException {
        return service.createUserAndPersonByManager(userDTO);
    }
}
