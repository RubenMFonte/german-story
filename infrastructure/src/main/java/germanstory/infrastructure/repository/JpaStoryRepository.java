package germanstory.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import germanstory.infrastructure.entity.StoryEntity;

@Repository
public interface JpaStoryRepository extends JpaRepository<StoryEntity, UUID> {
    
    List<StoryEntity> findByUsername(String username);
    
    @EntityGraph(value = "story-with-dependencies")
    Optional<StoryEntity> findById(@Param("id") UUID id);
}

