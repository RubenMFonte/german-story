package germanstory.adapters.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import germanstory.adapters.persistence.JpaStoryAdapter;
import germanstory.application.dto.StoryDTO;
import germanstory.application.dto.StoryListElementDTO;
import germanstory.application.service.GetStoryDataService;
import germanstory.application.service.GetStoryListService;

@RestController
@RequestMapping("/api/stories")
public class StoryDataController {

    @Autowired
    private JpaStoryAdapter jpaStoryAdapter;
    
    @GetMapping
    public ResponseEntity<StoryDTO> getStoryDataById(@RequestParam("storyId") UUID id) {
        GetStoryDataService getStoryDataService = new GetStoryDataService(jpaStoryAdapter);
        return ResponseEntity.ok(getStoryDataService.getStoryData(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<StoryListElementDTO>> getStoryListByUsername(@RequestParam("username") String username) {
        GetStoryListService getStoryListService = new GetStoryListService(jpaStoryAdapter);
        return ResponseEntity.ok(getStoryListService.getStoryList(username));
    }
}
