package germanstory.application.port.out;

import germanstory.domain.model.HighlightedWord;

import java.util.UUID;

public interface HighlightedWordRepository {
    public HighlightedWord saveWord(UUID storyId, String text, String translation);
}