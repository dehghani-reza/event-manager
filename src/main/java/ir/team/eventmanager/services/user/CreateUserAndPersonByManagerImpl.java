package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.Person;
import ir.team.eventmanager.domain.Role;
import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.dto.user.CreateUserDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;

@Service
public class CreateUserAndPersonByManagerImpl extends BaseUserService implements CreateUserAndPersonByManager{

    public boolean createUserAndPersonByManager(CreateUserDTO userDTO){
        boolean isCompleted = false;
        Person person = new Person();
        person.setFirstName(userDTO.getFirstName());
        person.setLastName(userDTO.getLastName());
        person.setDateOfBirth(Instant
                .ofEpochMilli(userDTO.getDateOfBirth())
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setIsEnable(false);
        user.setRole(Role.USER);
        user.setPerson(person);
        try {
            repository.save(user);
        }catch (Exception ex){
            logger.error("new user and person can't save",ex);
            return isCompleted;
        }
        isCompleted=true;
        return isCompleted;
    }
}
