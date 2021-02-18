package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.exceptions.user.UserNotFoundException;

public interface LoadUserByIdService {

    User loadUserById(Long id) throws UserNotFoundException;
}
