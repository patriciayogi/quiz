# React.js and Spring Data REST

We will be using Spring Data REST and its powerful backend functionality, combined with React’s sophisticated features
to build an easy-to-understand UI and Thymeleaf.

Spring Data REST provides a fast way to build hypermedia-powered repositories.

React is Facebook’s solution to efficient, fast, and easy-to-use views in JavaScript.

## RESTful web service application:

This application generates quizzes.

- load data to MySql database using Spring Data.
- retrieves data from MySql.

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
- Make Some Security Changes(regrant permissions)
  mysql> revoke all on db_example.* from 'springuser'@'%';
  mysql> grant select, insert, delete, update on db_example.* to 'springuser'@'%';
- run the application
  mvn clean install
- load with dummy questions:
  POST: load/