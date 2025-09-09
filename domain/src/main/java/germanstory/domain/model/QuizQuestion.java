package germanstory.domain.model;

import java.util.List;
import java.util.UUID;

public class QuizQuestion {
    private UUID id;
    private UUID storyId;
    private String text;
    private List<Answer> answers;

    public QuizQuestion(UUID id, UUID storyId, String text, List<Answer> answers) {
        this.id = id;
        this.storyId = storyId;
        this.text = text;
        this.answers = answers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStoryId() {
        return storyId;
    }

    public void setStoryId(UUID storyId) {
        this.storyId = storyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
