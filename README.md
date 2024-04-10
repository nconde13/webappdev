# Student Portal - Spring Boot Application

## Description
Spring boot application using JPA and Flyway migration


## Project setup
```
mvn clean install
```

### Run
```
java -jar Infrastructure/target/Infrastructure-0.0.1-SNAPSHOT.jar
```

#### Run with DEV profile
```
java -jar -Dspring.profiles.active=dev Infrastructure/target/Infrastructure-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```
#### Run with PROD profile
```
java -jar -Dspring.profiles.active=dev Infrastructure/target/Infrastructure-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```


### Run Swagger
```
http://localhost:9090/swagger-ui.html
```

## Unable to connect to database? - Troubleshooting Database Issues

#### 1. Make sure the database is running

#### 2. Check whether student_portal database is already created - if not, create it

#### 3. Check the datasource port number in the application.yml file - change 8889 to 3306 if you are using MySQL Workbench or XAMPP
```
jdbc:mysql://localhost:3306/student_portal?useSSL=false
```

#### 4. Check the datasource username and password in the application.yml file
- if using XAMPP, the default username is root and password is empty, so remove datasource password and flyway password
