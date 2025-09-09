package germanstory.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import germanstory.infrastructure.entity.QuizQuestionEntity;

@Repository
public interface JpaQuizQuestionRepository extends JpaRepository<QuizQuestionEntity, UUID> {
}
