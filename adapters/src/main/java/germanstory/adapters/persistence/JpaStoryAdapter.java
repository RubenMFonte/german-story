package germanstory.adapters.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import germanstory.application.dto.AnswerDTO;
import germanstory.application.dto.HighlightedWordDTO;
import germanstory.application.dto.QuizQuestionDTO;
import germanstory.application.dto.StoryDTO;
import germanstory.application.port.out.StoryRepository;
import germanstory.domain.model.Story;
import germanstory.infrastructure.entity.StoryEntity;
import germanstory.infrastructure.repository.JpaStoryRepository;
import jakarta.transaction.Transactional;

@Repository
public class JpaStoryAdapter implements StoryRepository {

    JpaStoryRepository jpaStoryRepository;

    public JpaStoryAdapter(JpaStoryRepository jpaStoryRepository) {
        this.jpaStoryRepository = jpaStoryRepository;
    }

    @Override
    @Transactional
    public List<Story> findStoriesByUsername(String username) {
        return 
        jpaStoryRepository.findByUsername(username)
                          .stream()
                          .map(story -> 
                            new Story( story.getId(), 
                                       story.getTitle(), 
                                       story.getText(),
                                       List.of(),
                                       List.of()
                            ))
                            .toList();
    }

    @Override
    public Story saveStory(StoryDTO story) {
        
        StoryEntity newStory = new StoryEntity("test_user",story.storyTitle(), story.storyText());
        newStory = jpaStoryRepository.save(newStory);
        return new Story(newStory.getId(), newStory.getTitle(), newStory.getText(), List.of(), List.of());
    }

    @Override
    public StoryDTO findStoryById(UUID storyId) {
        StoryEntity story = jpaStoryRepository.findById(storyId).get();

        return new StoryDTO( story.getTitle(), 
                             story.getText(),
                             story.getHighlightedWords()
                             .stream()
                             .map(word -> new HighlightedWordDTO(word.getText(), word.getTranslation()))
                             .toList(),
                             story.getQuizQuestions()
                             .stream()
                             .map(question -> 
                                    new QuizQuestionDTO( question.getText(),
                                                         question.getAnswers()
                                                         .stream()
                                                         .map(answer -> new AnswerDTO(answer.getText(), answer.getIsCorrect()))
                                                         .toList()
                                                         )
                                )
                             .toList()
                            );
    }
    
}
