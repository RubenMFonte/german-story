package germanstory.application.dto;

import java.util.List;

public record StoryDTO (
    String storyTitle,
    String storyText,
    List<HighlightedWordDTO> highlightedWords,
    List<QuizQuestionDTO> questions
) {

}
