package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.User;
import org.springframework.data.domain.Page;

public interface LoadAllUserService {

    Page<User> loadAllUser(int page,int size);
}
