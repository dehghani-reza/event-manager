package ir.team.eventmanager.repositories;

import ir.team.eventmanager.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository extends JpaRepository<BaseEntity,Long> {
}
