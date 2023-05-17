package com.sasha.task.UniversityAccountingSystem;

import com.sasha.task.UniversityAccountingSystem.entity.Degree;
import com.sasha.task.UniversityAccountingSystem.entity.Department;
import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import com.sasha.task.UniversityAccountingSystem.repository.DepartmentRepository;

import com.sasha.task.UniversityAccountingSystem.services.UserInteractionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityAccountingSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(UniversityAccountingSystemApplication.class, args);

        UserInteractionService userInteractionService = appContext.getBean(UserInteractionService.class);
        userInteractionService.startInteractiveSession();
    }

}
