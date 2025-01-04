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
