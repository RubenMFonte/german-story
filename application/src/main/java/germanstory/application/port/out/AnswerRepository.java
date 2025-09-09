package germanstory.application.port.out;

import germanstory.domain.model.Answer;

import java.util.UUID;

public interface AnswerRepository {
    public Answer saveAnswer(UUID questionId, String text, Boolean isCorrect);
}