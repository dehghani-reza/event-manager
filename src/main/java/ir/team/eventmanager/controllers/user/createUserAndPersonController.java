package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.dto.user.CreateUserDTO;
import ir.team.eventmanager.services.user.CreateUserAndPersonByManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class createUserAndPersonController extends UserController{

    private final CreateUserAndPersonByManager service;

    @Autowired
    public createUserAndPersonController(CreateUserAndPersonByManager service) {
        this.service = service;
    }

    @PostMapping(value = "/create-user-and-person")
    private boolean createUserAndPerson(@RequestBody CreateUserDTO userDTO){
        return service.createUserAndPersonByManager(userDTO);
    }
}
