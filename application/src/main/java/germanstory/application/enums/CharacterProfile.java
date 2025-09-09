package germanstory.application.enums;

import java.util.Random;

public enum CharacterProfile {
    CHILD("Child"),
    TEENAGER("Teenager"),
    ADULT("Adult"),
    STUDENT("Student"),
    TEACHER("Teacher"),
    TRAVELER("Traveler"),
    DETECTIVE("Detective"),
    SCIENTIST("Scientist");

    private final String description;

    CharacterProfile(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getRandomProfile() {
        CharacterProfile[] profiles = values();

        Random rand = new Random();
        return profiles[rand.nextInt(profiles.length)].getDescription();
    }
}