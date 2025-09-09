package germanstory.infrastructure.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quizquestion")
@Data
@NoArgsConstructor
public class QuizQuestionEntity {

    @Id
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "story", nullable = false)
    private StoryEntity story;

    @OneToMany(mappedBy = "quizQuestion")
    private List<AnswerEntity> answers;
    
    @Column(nullable = false)
    private String text;

    public QuizQuestionEntity(StoryEntity story, String text) {
        this.text = text;
        this.story = story;
    }
}

