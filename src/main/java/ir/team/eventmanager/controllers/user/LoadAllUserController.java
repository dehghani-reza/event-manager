package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.dto.user.UserForProfileDTO;
import ir.team.eventmanager.services.user.LoadAllUserService;
import ir.team.eventmanager.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoadAllUserController extends UserController{

    private final LoadAllUserService service;

    @Autowired
    public LoadAllUserController(LoadAllUserService service) {
        this.service = service;
    }

    @GetMapping(value = "load-all/{page}/{size}")
    public List<UserForProfileDTO> loadAllUser(@PathVariable int page, @PathVariable int size){
        return service
                .loadAllUser(page, size)
                .stream()
                .map(user -> new UserForProfileDTO(user.getUsername(),
                        Tools.nvl(user.getEmail(),""),
                        user.getIsEnable(),
                        user.getRole().name()))
                .collect(Collectors.toList());
    }
}
