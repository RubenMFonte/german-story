package germanstory.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import germanstory.infrastructure.entity.AnswerEntity;

@Repository
public interface JpaAnswerRepository extends JpaRepository<AnswerEntity, UUID> {
}
