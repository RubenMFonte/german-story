package germanstory.application.dto;

import java.util.List;

public record QuizQuestionDTO(
    String text,
    List<AnswerDTO> answers
) {
    
}
