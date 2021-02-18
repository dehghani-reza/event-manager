package ir.team.eventmanager.repositories;

import ir.team.eventmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//TODO soft delete and pagination
}
