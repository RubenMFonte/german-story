package germanstory.domain.service;

public class StoryPromptGenerator {
    
    public static String generateStoryPrompt(
        String languageLevel,
        String characterProfile,
        String storyCategory,
        String storyTone) {
        return  "Generate a story in german, 650-900 words long, suitable but challenging for a german learner of level " + languageLevel + 
                ". The main character is a " + characterProfile + ". The story category is " + storyCategory +
                " and follows a " + storyTone + " story tone." +
                ". Include in the story 10 words that the reader should focus on remembering and send them on a separate list. " +
                "Include also a list of 5 comprehension questions about the story that the reader should answer after reading the story." +
                "For every question send 4 possible answers, 3 wrong and 1 right, to question the reader as multiple-choice." +
                "Send me your answer in JSON with the format: { \"title\": \"story title\", \"story\": \"story text\", \"words\":\"word1:english translation, word2:english translation\" " +
                "\"questions\":\"question1:[correct]answer1,answer2,answer3,answer4;question2:answer1,answer2,[correct]answer3,answer4\"}, " +
                "swap 'story title' with the title, 'story text' with the text of the story, 'word1','word2', etc with the german words, " +
                "'english translation' with the english translation of the word, 'question1', 'question2', etc with the prompt of the questions " +
                "and 'answer1', 'answer2' with the answers";
    }
}
