package germanstory.infrastructure.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
public class AnswerEntity {

    @Id
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "quizquestion", nullable = false)
    private QuizQuestionEntity quizQuestion;
    
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Boolean isCorrect;

    public AnswerEntity(QuizQuestionEntity question, String text, Boolean isCorrect) {
        this.quizQuestion = question;
        this.text = text;
        this.isCorrect = isCorrect;
    }
    
}
