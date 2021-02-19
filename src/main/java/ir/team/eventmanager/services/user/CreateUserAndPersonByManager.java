package ir.team.eventmanager.services.user;

import ir.team.eventmanager.dto.user.CreateUserDTO;
import ir.team.eventmanager.exceptions.user.CreateUserException;

public interface CreateUserAndPersonByManager {

    boolean createUserAndPersonByManager(CreateUserDTO userDTO) throws CreateUserException;
}
