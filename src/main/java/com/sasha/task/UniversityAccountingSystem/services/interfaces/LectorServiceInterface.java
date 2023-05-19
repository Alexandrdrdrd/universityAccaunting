package com.sasha.task.UniversityAccountingSystem.services.interfaces;


public interface LectorServiceInterface {

    /**
     * Performs a global search for lectors based on the provided template.
     * The search is case-insensitive and looks for lectors whose names contain the template.
     *
     * @param template the search template
     * @return a string representation of the matching lector names separated by commas,
     * or "No matching results" if no lectors match the search
     */
    String globalSearch(String template);
}
