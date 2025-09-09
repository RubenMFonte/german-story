package germanstory.domain.model;

import java.util.UUID;

public class HighlightedWord {
    
    private UUID storyId;
    private String text;
    private String translation;

    public HighlightedWord(UUID storyId, String text, String translation) {
        this.storyId = storyId;
        this.text = text;
        this.translation = translation;
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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
