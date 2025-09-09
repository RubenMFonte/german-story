package germanstory.infrastructure.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "story")
@Data
@NoArgsConstructor
@NamedEntityGraph(
    name = "story-with-dependencies",
    attributeNodes = {
        @NamedAttributeNode("highlightedWords"),
        @NamedAttributeNode(value = "quizQuestions", subgraph = "quizquestions-with-answers")
    },
    subgraphs = {
        @NamedSubgraph(name = "quizquestions-with-answers", attributeNodes = @NamedAttributeNode("answers"))
    }
)
public class StoryEntity {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;
    
    @Lob
    @Column(nullable = false)
    private String text;

    @OneToMany(mappedBy = "story")
    private List<HighlightedWordEntity> highlightedWords;
    
    @OneToMany(mappedBy = "story")
    private List<QuizQuestionEntity> quizQuestions;

    public StoryEntity(String username, String title, String text) {
        this.username = username;
        this.title = title;
        this.text = text;
    }
    
}
