package ir.team.eventmanager.services.user;

import ir.team.eventmanager.domain.User;
import ir.team.eventmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LoadAllUserServiceImpl extends BaseUserService implements LoadAllUserService{


    @Override
    public Page<User> loadAllUser(int page,int size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("username")));
    }
}
