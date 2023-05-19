package com.sasha.task.UniversityAccountingSystem.services.implementations;

import com.sasha.task.UniversityAccountingSystem.services.interfaces.UserInteractionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInteractionServiceImpl implements UserInteractionServiceInterface {
    private final DepartmentServiceImpl departmentServiceImpl;
    private final LectorServiceImpl lectorServiceImpl;

    @Autowired
    public UserInteractionServiceImpl(DepartmentServiceImpl departmentServiceImpl, LectorServiceImpl lectorServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
        this.lectorServiceImpl = lectorServiceImpl;
    }

    /**
     * Starts an interactive session for user interaction.
     * Reads user commands from the console and executes them until the user enters 'exit'.
     */
    public void startInteractiveSession() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nEnter your command (or 'exit' to quit):");
            System.out.println("Available commands: \n Who is head of department {department_name} \n" +
                    " Show {department_name} statistics \n " +
                    "Show the average salary for the department {department_name} \n" +
                    " Show count of employee for {department_name}. \n" +
                    " Global search by {template}" );

            String command = scanner.nextLine();

            String result = executeCommand(command);
            System.out.println(result);

            if (command.equalsIgnoreCase("exit")) {
                running = false;
            }
        }

        scanner.close();
    }

    /**
     * Executes the given command and returns the result as a string.
     *
     * @param command the command to execute
     * @return the result of the command execution
     */
    private String executeCommand(String command) {
        if (command.startsWith("Who is head of department")) {
            String departmentName = extractParameter(command);
            return departmentServiceImpl.getDepartmentHead(departmentName);
        } else if (command.startsWith("Show")) {
            if (command.contains("statistics")) {
                String departmentName = extractParameter(command);
                return departmentServiceImpl.getDepartmentStatistics(departmentName);
            } else if (command.contains("average salary")) {
                String departmentName = extractParameter(command);
                return departmentServiceImpl.getAverageSalary(departmentName);
            } else if (command.contains("count of employee")) {
                String departmentName = extractParameter(command);
                return departmentServiceImpl.getEmployeeCount(departmentName);
            }
        } else if (command.startsWith("Global search by")) {
            String template = extractParameter(command);
            return lectorServiceImpl.globalSearch(template);
        }

        return "Invalid command";
    }

    /**
     * Extracts the parameter from the given command.
     *
     * @param command the command from which to extract the parameter
     * @return the extracted parameter
     */
    private String extractParameter(String command) {
        String[] words = command.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (isCommandKeyword(words[i])) {
                if (i < words.length - 1) {
                    return words[i + 1];
                } else {
                    return "";
                }
            }
        }
        return "";
    }

    /**
     * Checks if the given word is a keyword used in commands.
     *
     * @param word the word to check
     * @return true if the word is a command keyword, false otherwise
     */
    private boolean isCommandKeyword(String word) {
        return word.equalsIgnoreCase("department")
                || word.equalsIgnoreCase("Show")
                || word.equalsIgnoreCase("for")
                || word.equalsIgnoreCase("by");
    }

}
