package germanstory.adapters.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import germanstory.application.port.out.QuizQuestionRepository;
import germanstory.domain.model.QuizQuestion;
import germanstory.infrastructure.entity.QuizQuestionEntity;
import germanstory.infrastructure.entity.StoryEntity;
import germanstory.infrastructure.repository.JpaQuizQuestionRepository;
import germanstory.infrastructure.repository.JpaStoryRepository;

@Repository
public class JpaQuizQuestionAdapter implements QuizQuestionRepository {

    JpaQuizQuestionRepository jpaQuizQuestionRepository;
    JpaStoryRepository jpaStoryRepository;

    public JpaQuizQuestionAdapter(JpaQuizQuestionRepository jpaQuizQuestionRepository, JpaStoryRepository jpaStoryRepository) {
        this.jpaQuizQuestionRepository = jpaQuizQuestionRepository;
        this.jpaStoryRepository = jpaStoryRepository;
    }

    @Override
    public QuizQuestion saveQuestion(UUID storyId, String text) {

        StoryEntity story = jpaStoryRepository.getReferenceById(storyId);
        QuizQuestionEntity newQuizQuestion = jpaQuizQuestionRepository.save(new QuizQuestionEntity(story,text));
        return new QuizQuestion(newQuizQuestion.getId(), newQuizQuestion.getStory().getId(), newQuizQuestion.getText(), List.of());
    }


    
}
