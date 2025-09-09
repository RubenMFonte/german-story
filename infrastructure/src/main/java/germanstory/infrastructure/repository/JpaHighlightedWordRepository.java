package germanstory.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import germanstory.infrastructure.entity.HighlightedWordEntity;

@Repository
public interface JpaHighlightedWordRepository extends JpaRepository<HighlightedWordEntity, UUID> {
}
