package com.sasha.task.UniversityAccountingSystem;

import com.sasha.task.UniversityAccountingSystem.services.implementations.UserInteractionServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityAccountingSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(UniversityAccountingSystemApplication.class, args);

        UserInteractionServiceImpl userInteractionServiceImpl = appContext.getBean(UserInteractionServiceImpl.class);
        userInteractionServiceImpl.startInteractiveSession();
    }

}
