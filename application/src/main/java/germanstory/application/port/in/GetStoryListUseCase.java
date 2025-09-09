package germanstory.application.port.in;

import java.util.List;

import germanstory.application.dto.StoryListElementDTO;;

public interface GetStoryListUseCase {

    public List<StoryListElementDTO> getStoryList(String username);
}
