# Spring Data - MySql

This application generates quizzes.

- load data to MySql database using Spring Data.
- retrieves data from MySql.

## Sample RESTful web service application:

- Retrieve data from MySql

## What You Need

- Java 17
- Postman
- MySql DB
  ### Docker compose
- docker-compose up -d
  or manually creation
- mysql> create database db_example; -- Creates the new database
  mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
  mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created
  database

- setup the db credentials in the application properties:
  spring.jpa.hibernate.ddl-auto=update
  spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
  spring.datasource.username=springuser
  spring.datasource.password=ThePassword
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

### Reference Documentation

Go to MongoDB and follow the below steps to create your database for the project

- Getting Started with Atlas: https://www.mongodb.com/docs/atlas/getting-started/
