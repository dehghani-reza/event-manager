package ir.team.eventmanager.repositories;

import ir.team.eventmanager.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseEntityRepository<User> {
//TODO soft delete and pagination
    //https://stackoverflow.com/questions/19323557/handling-soft-deletes-with-spring-jpa
}
