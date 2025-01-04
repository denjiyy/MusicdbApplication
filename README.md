# MusicDB Application

MusicDB is a Spring Boot-based application that allows users to interact with a database of music records. This project uses Gradle as its build tool and provides both a Swagger interface for API documentation and a customizable front-end interface.

---

## Prerequisites

To run this application, ensure you have the following installed on your system:

- **Java**: Version 11
- **Gradle**: Version compatible with the project
- **Spring Boot**: Version 2.4.3 (already configured in the project)
- **Server Port**: 8080

---

## Features

- **API Documentation**: Easily access Swagger UI at `/swagger-ui.html` for interactive API documentation.
- **Customizable Front-End**: Modify the annotations to switch between RESTful and front-end controller modes. (@RestController => @Controller)

---

## Project Structure

test {
├───.idea
├───docker
├───gradle
│   └───wrapper
├───local
└───src
    ├───main
    │   ├───java
    │   │   └───bg
    │   │       └───musicapp
    │   │           └───musicdb
    │   │               ├───aop
    │   │               ├───config
    │   │               ├───exceptions
    │   │               ├───model
    │   │               │   ├───binding
    │   │               │   ├───entities
    │   │               │   │   └───enums
    │   │               │   ├───service
    │   │               │   ├───validators
    │   │               │   └───view
    │   │               ├───repository
    │   │               ├───service
    │   │               │   └───impl
    │   │               └───web
    │   └───resources
    │       ├───init
    │       ├───static
    │       │   ├───css
    │       │   ├───images
    │       │   └───js
    │       └───templates
    │           └───fragments
    └───test
        ├───java
        │   └───bg
        │       └───musicapp
        │           └───musicdb
        │               ├───musicdb
        │               │   ├───service
        │               │   │   └───impl
        │               │   └───web
        │               └───service
        └───resources
}
---

## Dependencies

The project uses the following dependencies, configured in the `build.gradle` file:

### Plugins
- **Spring Boot**: `org.springframework.boot` version `2.4.3`
- **Spring Dependency Management**: `io.spring.dependency-management` version `1.0.11.RELEASE`
- **Java Plugin**

### Runtime and Build Dependencies
- **Google Gson**: `com.google.code.gson:gson:2.8.6` (for JSON parsing)
- **ModelMapper**: `org.modelmapper:modelmapper:2.3.0` (for object mapping)
- **Spring Boot Actuator**: `org.springframework.boot:spring-boot-starter-actuator` (monitoring and management)
- **Spring Boot Security**: `org.springframework.boot:spring-boot-starter-security` (authentication and authorization)
- **Spring Boot Thymeleaf**: `org.springframework.boot:spring-boot-starter-thymeleaf` (server-side template engine)
- **Spring Boot Validation**: `org.springframework.boot:spring-boot-starter-validation` (for data validation)
- **Spring Boot Web**: `org.springframework.boot:spring-boot-starter-web` (for building RESTful web applications)
- **Spring Boot Data JPA**: `org.springframework.boot:spring-boot-starter-data-jpa` (for database interactions)
- **Spring Security Thymeleaf Extras**: `org.thymeleaf.extras:thymeleaf-extras-springsecurity5` (Thymeleaf integration with Spring Security)
- **Spring Boot AOP**: `org.springframework.boot:spring-boot-starter-aop` (aspect-oriented programming)
- **SpringDoc OpenAPI UI**: `org.springdoc:springdoc-openapi-ui:1.6.0` (API documentation with OpenAPI)
- **MySQL Connector**: `mysql:mysql-connector-java` (for MySQL database connectivity)

### Development-Only Dependencies
- **Spring Boot DevTools**: `org.springframework.boot:spring-boot-devtools` (enhances development experience)

### Testing Dependencies
- **H2 Database**: `com.h2database:h2` (in-memory database for testing)
- **Spring Boot Test**: `org.springframework.boot:spring-boot-starter-test` (testing utilities for Spring Boot)
- **Spring Security Test**: `org.springframework.security:spring-security-test` (testing utilities for Spring Security)

---

## Build Configuration

The application is built with the following configurations:

- **Group**: `bg.musicapp`
- **Source Compatibility**: Java 11
- **Main Class**: `bg.musicapp.MusicdbApplication` (configured in `springBoot.mainClass`)

### Repositories
The project uses **Maven Central** as the primary repository for resolving dependencies.

### Testing
The application uses the **JUnit Platform** for testing, as configured in the `test` block of the `build.gradle` file:
```groovy
test {
    useJUnitPlatform()
}
