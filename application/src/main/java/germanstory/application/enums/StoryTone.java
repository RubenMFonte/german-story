package germanstory.application.enums;

import java.util.Random;

public enum StoryTone {
    HUMOROUS("Humorous"),
    SERIOUS("Serious"),
    MYSTERIOUS("Mysterious"),
    DRAMATIC("Dramatic"),
    ROMANTIC("Romantic"),
    ADVENTUROUS("Adventurous"),
    INSPIRATIONAL("Inspirational"),
    DARK("Dark"),
    LIGHTHEARTED("Lighthearted"),
    FANTASTICAL("Fantastical");

    private final String description;

    StoryTone(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getRandomTone() {
        StoryTone[] tones = values();
        
        Random rand = new Random();
        return tones[rand.nextInt(tones.length)].getDescription();
    }
}