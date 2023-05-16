package com.sasha.task.UniversityAccountingSystem;

import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import com.sasha.task.UniversityAccountingSystem.repository.DepartmentRepository;
import com.sasha.task.UniversityAccountingSystem.repository.LectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityAccountingSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(UniversityAccountingSystemApplication.class, args);

		LectorsRepository repository = appContext.getBean(LectorsRepository.class);
		DepartmentRepository departmentRepository = appContext.getBean(DepartmentRepository.class);

		System.out.println(repository.findAll());
		System.out.println(departmentRepository.findAll());
	}

}
