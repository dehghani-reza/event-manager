package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.exceptions.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoadUserByIdServiceImpl extends BaseUserService implements LoadUserByIdService {

    @Override
    public User loadUserById(Long id) throws UserNotFoundException {
        Optional<User> byId = repository.findById(id);
        return byId.orElseThrow(() -> new UserNotFoundException("can't find user with id: "+id));
    }
}
