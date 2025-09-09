package germanstory.infrastructure.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "highlightedword")
@Data
@NoArgsConstructor
public class HighlightedWordEntity {

    @Id
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "story", nullable = false)
    private StoryEntity story;
    
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private String translation;

    public HighlightedWordEntity(StoryEntity story, String text, String translation) {
        this.story = story;
        this.text = text;
        this.translation = translation;
    }
    
}

