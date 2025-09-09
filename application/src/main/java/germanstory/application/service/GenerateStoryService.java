package germanstory.application.service;

import java.util.ArrayList;
import java.util.List;

import germanstory.application.enums.CharacterProfile;
import germanstory.application.enums.StoryCategory;
import germanstory.application.enums.StoryTone;
import germanstory.application.dto.QuizQuestionDTO;
import germanstory.application.dto.StoryDTO;
import germanstory.application.port.in.GenerateStoryUseCase;
import germanstory.application.port.out.AnswerRepository;
import germanstory.application.port.out.HighlightedWordRepository;
import germanstory.application.port.out.QuizQuestionRepository;
import germanstory.application.port.out.StoryGeneratorPort;
import germanstory.application.port.out.StoryParserPort;
import germanstory.application.port.out.StoryRepository;
import germanstory.domain.model.QuizQuestion;
import germanstory.domain.model.Story;
import germanstory.domain.service.StoryPromptGenerator;

public class GenerateStoryService implements GenerateStoryUseCase {

    private StoryGeneratorPort storyGenerator;
    private StoryParserPort jsonStoryParser;
    private StoryRepository storyRepository;
    private HighlightedWordRepository highlightedWordRepository;
    private QuizQuestionRepository quizQuestionRepository;
    private AnswerRepository answerRepository;

    public GenerateStoryService( 
        StoryGeneratorPort storyGenerator,
        StoryParserPort jsonStoryParser,
        StoryRepository storyRepository,
        HighlightedWordRepository highlightedWordRepository,
        QuizQuestionRepository quizQuestionRepository,
        AnswerRepository answerRepository) {

        this.storyGenerator = storyGenerator;
        this.jsonStoryParser = jsonStoryParser;
        this.storyRepository = storyRepository;
        this.highlightedWordRepository = highlightedWordRepository;
        this.quizQuestionRepository = quizQuestionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Story generateStory(String languageLevel) {
        
        String storyPrompt = StoryPromptGenerator.generateStoryPrompt(
            languageLevel, 
            CharacterProfile.getRandomProfile(), 
            StoryCategory.getRandomCategory(), 
            StoryTone.getRandomTone());

        StoryDTO storyDTO = jsonStoryParser.parseStoryJson(storyGenerator.requestStory(storyPrompt));

        Story newStory = storyRepository.saveStory(storyDTO);

        newStory.setHighlightedWords(
            storyDTO.highlightedWords()
            .stream()
            .map( word -> highlightedWordRepository.saveWord(newStory.getId(), word.text(), word.translation()) )
            .toList()
        );

        List<QuizQuestion> questions = new ArrayList<>();

        for(QuizQuestionDTO question : storyDTO.questions()) {
            QuizQuestion newQuestion = quizQuestionRepository.saveQuestion(newStory.getId(), question.text());

            newQuestion.setAnswers(
                question.answers()
                        .stream()
                        .map(answer -> answerRepository.saveAnswer(newQuestion.getId(), answer.text(), answer.isCorrect()))
                        .toList()  
            );

            questions.add(newQuestion);
        }

        newStory.setQuestions(questions);

        return newStory;
    }
}

