
# University Management System

The University Management System is a Java-based application that provides functionality to manage departments and lecturers within a university. It allows users to perform various operations such as retrieving department information, finding department heads, obtaining department statistics, and conducting global searches for lecturers.

## Features

- Retrieval of department information:
    - Get the head of a department.
    - Get department statistics (assistant count, associate professor count, professor count).
    - Get the average salary of a department.
    - Get the employee count of a department.

- Global search for lecturers based on a template.

## Technologies Used

- Java
- Spring Framework
- Spring Data JPA
- PostgresSQL (or any other supported database)
- Maven (for dependency management)
- Git (for version control)

## Getting Started

To get started with the University Management System, follow these steps:

1. Clone the repository:

   ```
   git clone <repository-url>
   ```

2. Open the project in your preferred Java IDE.

3. Set up the database connection in the `application.properties` file by configuring the database URL, username, and password.

4. Run the application.

5. You can use test data from data.sql, if you don't need it just delete file)
Remember: if you will use data.sql with test data, you should delete data from DB every restart of the application.


## Usage

Once the application is up and running, you can interact with it through a command-line interface. Enter commands to perform various operations, such as retrieving department information, finding department heads, obtaining department statistics, and conducting global searches for lecturers.

Here are some example commands:

- **Who is head of department \<departmentName>**: Retrieves the head of the specified department.

- **Show \<departmentName> statistics**: Retrieves the statistics (assistant count, associate professor count, professor count) for the specified department.

- **Show \<departmentName> average salary**: Retrieves the average salary of the lecturers in the specified department.

- **Show \<departmentName> count of employee**: Retrieves the employee count of the specified department.

- **Global search by \<template>**: Performs a global search for lecturers based on the specified template.

- **exit**: Exits the application.
