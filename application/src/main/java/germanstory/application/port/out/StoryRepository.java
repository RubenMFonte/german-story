package germanstory.application.port.out;

import java.util.List;
import java.util.UUID;

import germanstory.application.dto.StoryDTO;
import germanstory.domain.model.Story;

public interface StoryRepository {
    public List<Story> findStoriesByUsername(String username);
    public Story saveStory(StoryDTO story);
    public StoryDTO findStoryById(UUID storyId);
}
