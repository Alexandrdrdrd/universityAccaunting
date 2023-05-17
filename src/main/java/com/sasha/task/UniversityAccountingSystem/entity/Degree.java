package com.sasha.task.UniversityAccountingSystem.entity;

/**
 * Enum representing the academic degrees in a university.
 */
public enum Degree {
    ASSISTANT("Assistant"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    PROFESSOR("Professor");

    private String displayName;

    /**
     * Constructs a new Degree enum constant with the specified display name.
     *
     * @param displayName the display name of the degree
     */
    Degree(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the degree.
     *
     * @return the display name of the degree
     */
    public String getDisplayName() {
        return displayName;
    }
}
