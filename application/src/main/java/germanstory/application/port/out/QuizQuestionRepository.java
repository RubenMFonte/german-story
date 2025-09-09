package germanstory.application.port.out;

import germanstory.domain.model.QuizQuestion;

import java.util.UUID;

public interface QuizQuestionRepository {
    public QuizQuestion saveQuestion(UUID storyId, String text);
}