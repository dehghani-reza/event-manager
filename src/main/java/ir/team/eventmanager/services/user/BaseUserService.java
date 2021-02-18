package ir.team.eventmanager.services.user;

import ir.team.eventmanager.repositories.UserRepository;
import ir.team.eventmanager.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseUserService extends BaseService {

    @Autowired
    protected UserRepository repository;

}
