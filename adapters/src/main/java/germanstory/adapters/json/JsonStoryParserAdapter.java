package germanstory.adapters.json;

import germanstory.application.dto.AnswerDTO;
import germanstory.application.dto.HighlightedWordDTO;
import germanstory.application.dto.QuizQuestionDTO;
import germanstory.application.dto.StoryDTO;
import germanstory.application.port.out.StoryParserPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;

public class JsonStoryParserAdapter implements StoryParserPort {

    private static class RawStoryData {
        public String title;
        public String story;
        public String words;
        public String questions;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getStory() { return story; }
        public void setStory(String story) { this.story = story; }
        public String getWords() { return words; }
        public void setWords(String words) { this.words = words; }
        public String getQuestions() { return questions; }
        public void setQuestions(String questions) { this.questions = questions; }

        public RawStoryData() {}
    }

    @Override
    public StoryDTO parseStoryJson(String jsonData) {

        try {

            int jsonStart = jsonData.indexOf("{");
            int jsonEnd = jsonData.indexOf("}");

            String trimmedJsonData = jsonData.substring(jsonStart, jsonEnd+1);

            ObjectMapper objectMapper = new ObjectMapper();

            RawStoryData rawData = objectMapper.readValue(trimmedJsonData, RawStoryData.class);
            
            // HighlightedWords
            List<HighlightedWordDTO> highlightedWords = new ArrayList<>();

            if (rawData.getWords() != null && !rawData.getWords().isEmpty()) {
                String[] wordPairs = rawData.getWords().split(",");
                for (String pair : wordPairs) {
                    String[] parts = pair.trim().split(":");
                    if (parts.length == 2) {
                        String text = parts[0].trim();
                        String translation = parts[1].trim();
                        highlightedWords.add(new HighlightedWordDTO(text, translation));
                    }
                }
            }

            // Quiz Questions
            List<QuizQuestionDTO> quizQuestions = new ArrayList<>();

            if (rawData.getQuestions() != null && !rawData.getQuestions().isEmpty()) {
                String[] questionStrings = rawData.getQuestions().split(";");
                for (String qString : questionStrings) {
                    String[] parts = qString.trim().split(":", 2);
                    if (parts.length == 2) {
                        String questionText = parts[0].trim();
                        List<AnswerDTO> answers = new ArrayList<>();
                        String[] answerStrings = parts[1].split(",");

                        for (String aString : answerStrings) {
                            boolean isCorrect = aString.contains("[correct]");
                            String answerText = aString.replace("[correct]", "").trim();
                            answers.add(new AnswerDTO(answerText, isCorrect));
                        }
                        quizQuestions.add(new QuizQuestionDTO(questionText, answers));
                    }
                }
            }

            return new StoryDTO(rawData.getTitle(), rawData.getStory(), highlightedWords, quizQuestions);
            
        } catch (JsonProcessingException e) {
            System.err.println("Error parsing JSON string: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}
