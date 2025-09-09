package germanstory.application.service;

import java.util.List;

import germanstory.application.dto.StoryListElementDTO;
import germanstory.application.port.in.GetStoryListUseCase;
import germanstory.application.port.out.StoryRepository;

public class GetStoryListService implements GetStoryListUseCase {

    StoryRepository storyRepository;

    public GetStoryListService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public List<StoryListElementDTO> getStoryList(String username) {
        return storyRepository.findStoriesByUsername(username)
                              .stream()
                              .map(story -> new StoryListElementDTO(story.getId(), story.getStoryTitle()))
                              .toList();
    }
    
}
