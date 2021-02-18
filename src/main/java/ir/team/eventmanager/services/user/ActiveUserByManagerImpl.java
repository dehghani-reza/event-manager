package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.exceptions.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActiveUserByManagerImpl extends BaseUserService implements ActiveUserByManager{

    @Override
    public User activeUserByManagerWithId(Long id) throws UserNotFoundException {
        Optional<User> byId = repository.findById(id);
        User user = byId.orElseThrow(() -> new UserNotFoundException("can't find user with id: " + id));
        user.setIsEnable(true);
        return repository.save(user);
    }
}
