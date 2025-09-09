package germanstory.adapters.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import germanstory.application.port.out.HighlightedWordRepository;
import germanstory.domain.model.HighlightedWord;
import germanstory.infrastructure.entity.HighlightedWordEntity;
import germanstory.infrastructure.entity.StoryEntity;
import germanstory.infrastructure.repository.JpaHighlightedWordRepository;
import germanstory.infrastructure.repository.JpaStoryRepository;

@Repository
public class JpaHighlightedWordAdapter implements HighlightedWordRepository {

    JpaHighlightedWordRepository jpaHighlightedWordRepository;
    JpaStoryRepository jpaStoryRepository;

    public JpaHighlightedWordAdapter(JpaHighlightedWordRepository jpaHighlightedWordRepository, JpaStoryRepository jpaStoryRepository) {
        this.jpaHighlightedWordRepository = jpaHighlightedWordRepository;
        this.jpaStoryRepository = jpaStoryRepository;
    }

    @Override
    public HighlightedWord saveWord(UUID storyId, String text, String translation) {
        
        StoryEntity story = jpaStoryRepository.getReferenceById(storyId);
        HighlightedWordEntity newWord = new HighlightedWordEntity(story, text, translation);
        jpaHighlightedWordRepository.save(newWord);
        return new HighlightedWord(newWord.getStory().getId(), newWord.getText(), newWord.getTranslation()); 
    }
    
}
