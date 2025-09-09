package germanstory.adapters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import germanstory.domain.model.Story;
import germanstory.adapters.json.JsonStoryParserAdapter;
import germanstory.adapters.llm.OpenAIAdapter;
import germanstory.adapters.persistence.JpaAnswerAdapter;
import germanstory.adapters.persistence.JpaHighlightedWordAdapter;
import germanstory.adapters.persistence.JpaQuizQuestionAdapter;
import germanstory.adapters.persistence.JpaStoryAdapter;
import germanstory.application.port.in.GenerateStoryUseCase;
import germanstory.application.service.GenerateStoryService;

@RestController
@RequestMapping("/api/generator")
public class GenerateStoryController {
    
    @Autowired
    private OpenAIAdapter openAIAdapter;
    
    @Autowired
    private JpaStoryAdapter jpaStoryAdapter;
    
    @Autowired
    private JpaHighlightedWordAdapter jpaHighlightedWordAdapter;
    
    @Autowired
    private JpaQuizQuestionAdapter jpaQuizQuestionAdapter;
    
    @Autowired
    private JpaAnswerAdapter jpaAnswerAdapter;

    public GenerateStoryController() {}

    @GetMapping
    public ResponseEntity<Story> generateStory(@RequestParam("languageLevel") String languageLevel) {

        GenerateStoryUseCase generateStoryUseCase = 
            new GenerateStoryService(openAIAdapter,
                                     new JsonStoryParserAdapter(),
                                     jpaStoryAdapter,
                                     jpaHighlightedWordAdapter,
                                     jpaQuizQuestionAdapter,
                                     jpaAnswerAdapter
                                    );

        return ResponseEntity.ok(generateStoryUseCase.generateStory(languageLevel));
    }
}
