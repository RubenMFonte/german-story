package germanstory.application.service;

import java.util.UUID;

import germanstory.application.dto.StoryDTO;
import germanstory.application.port.in.GetStoryDataUseCase;
import germanstory.application.port.out.StoryRepository;

public class GetStoryDataService implements GetStoryDataUseCase {
    StoryRepository storyRepository;

    public GetStoryDataService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public StoryDTO getStoryData(UUID storyId) {
        return storyRepository.findStoryById(storyId);
    }


}
