package germanstory.domain.model;

import java.util.List;
import java.util.UUID;

public class Story {
    
    private UUID id;
    private String storyTitle;
    private String storyText;
    private List<HighlightedWord> highlightedWords;
    private List<QuizQuestion> questions;

    public Story(UUID id, String storyTitle, String storyText, List<HighlightedWord> highlightedWords,
            List<QuizQuestion> questions) {
        this.id = id;
        this.storyTitle = storyTitle;
        this.storyText = storyText;
        this.highlightedWords = highlightedWords;
        this.questions = questions;
    }

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public List<HighlightedWord> getHighlightedWords() {
        return highlightedWords;
    }

    public void setHighlightedWords(List<HighlightedWord> highlightedWords) {
        this.highlightedWords = highlightedWords;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }
}
