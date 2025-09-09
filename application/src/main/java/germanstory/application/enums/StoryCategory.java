package germanstory.application.enums;

import java.util.Random;

public enum StoryCategory {
    EVERYDAY_LIFE("Everyday life and daily routines"),
    TRAVEL_CULTURE("Travel, traditions, and cultural experiences"),
    MYSTERY_ADVENTURE("Mystery and adventure stories"),
    COMEDY_SLICE_OF_LIFE("Comedy and slice-of-life"),
    FANTASY_SCI_FI("Fantasy and science fiction"),
    HISTORY_LEGENDS("Historical events and legends"),
    NATURE_ENVIRONMENT("Nature, animals, and the environment"),
    SCHOOL_LEARNING("School and learning situations"),
    WORK_PROFESSIONS("Work, jobs, and professions"),
    RELATIONSHIPS_EMOTIONS("Relationships and emotions");

    private final String description;

    StoryCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getRandomCategory() {
        StoryCategory[] categories = values();

        Random rand = new Random();
        return categories[rand.nextInt(categories.length)].getDescription();
    }
}