package germanstory.application.dto;

import java.util.UUID;

public record StoryListElementDTO(
    UUID storyId,
    String storyTitle
) {
    
}
