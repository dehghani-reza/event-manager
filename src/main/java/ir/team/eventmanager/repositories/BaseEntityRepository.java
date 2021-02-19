package ir.team.eventmanager.repositories;

import ir.team.eventmanager.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T,Long> {

}
