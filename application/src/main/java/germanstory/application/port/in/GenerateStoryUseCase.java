package germanstory.application.port.in;

import germanstory.domain.model.Story;

public interface GenerateStoryUseCase {
    
    public Story generateStory(String languageLevel);
}
