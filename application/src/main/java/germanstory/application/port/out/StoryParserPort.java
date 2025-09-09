package germanstory.application.port.out;

import germanstory.application.dto.StoryDTO;

public interface StoryParserPort {
    public StoryDTO parseStoryJson(String jsonData);
}
