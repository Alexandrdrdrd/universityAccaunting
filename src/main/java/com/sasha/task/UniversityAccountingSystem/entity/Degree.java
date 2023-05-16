package com.sasha.task.UniversityAccountingSystem.entity;

public enum Degree {
    Assistant("Assistant"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    Professor("Professor");

    private String displayName;

    Degree(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}