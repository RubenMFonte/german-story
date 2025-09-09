package germanstory.application.port.in;

import java.util.UUID;

import germanstory.application.dto.StoryDTO;

public interface GetStoryDataUseCase {
    public StoryDTO getStoryData(UUID storyId);
}
