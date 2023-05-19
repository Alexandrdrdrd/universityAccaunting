package com.sasha.task.UniversityAccountingSystem.services.interfaces;

/**
 * Interface for UserInteractionService.
 */
public interface UserInteractionServiceInterface {

    /**
     * Starts an interactive session for user interaction.
     * Reads user commands from the console and executes them until the user enters 'exit'.
     */
    void startInteractiveSession();

}
