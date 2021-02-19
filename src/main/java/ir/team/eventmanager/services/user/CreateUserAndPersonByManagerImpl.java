package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.Person;
import ir.team.eventmanager.domain.Role;
import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.dto.user.CreateUserDTO;
import ir.team.eventmanager.exceptions.user.CreateUserException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CreateUserAndPersonByManagerImpl extends BaseUserService implements CreateUserAndPersonByManager{

    public boolean createUserAndPersonByManager(CreateUserDTO userDTO) throws CreateUserException {
        if(userDTO.getDateOfBirth()>new Date().getTime())
            throw new CreateUserException("date of birth can't be in feature");
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
