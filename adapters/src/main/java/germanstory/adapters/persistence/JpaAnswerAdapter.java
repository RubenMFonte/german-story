package germanstory.adapters.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import germanstory.application.port.out.AnswerRepository;
import germanstory.domain.model.Answer;
import germanstory.infrastructure.entity.AnswerEntity;
import germanstory.infrastructure.entity.QuizQuestionEntity;
import germanstory.infrastructure.repository.JpaAnswerRepository;
import germanstory.infrastructure.repository.JpaQuizQuestionRepository;

@Repository
public class JpaAnswerAdapter implements AnswerRepository {

    JpaAnswerRepository jpaAnswerRepository;
    JpaQuizQuestionRepository jpaQuizQuestionRepository;

    public JpaAnswerAdapter(JpaAnswerRepository jpaAnswerRepository, JpaQuizQuestionRepository jpaQuizQuestionRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
        this.jpaQuizQuestionRepository = jpaQuizQuestionRepository;
    }

    @Override
    public Answer saveAnswer(UUID questionId, String text, Boolean isCorrect) {
        QuizQuestionEntity question = jpaQuizQuestionRepository.getReferenceById(questionId);
        AnswerEntity newAnswer = new AnswerEntity(question, text, isCorrect);
        jpaAnswerRepository.save(newAnswer);
        return new Answer(newAnswer.getQuizQuestion().getId(), newAnswer.getText(), newAnswer.getIsCorrect()); 
    }
}
