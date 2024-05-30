
# Temirlan_CHAT_SPRING

This project is a Spring Boot application designed to manage user tasks and chats, with a PostgreSQL database for persistence. The application is containerized using Docker and Docker Compose.

## Table of Contents

- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Troubleshooting](#troubleshooting)

## Project Description

Temirlan_CHAT_SPRING is a chat application that allows users to register, log in, create chat rooms, and exchange messages. The backend is built with Spring Boot and connects to a PostgreSQL database. The application is packaged into Docker containers for easy deployment.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Docker
- Docker Compose
- Flyway (for database migrations)
- WebSocket

## Project Structure

```
com.example.demo
├── auth
│   ├── AuthentificationController
│   ├── AuthentificationRequest
│   ├── AuthentificationResponse
│   ├── AuthentificationService
│   └── RegisterRequest
├── config
│   ├── ApplicationConfig
│   ├── JwtAuthentificationFilter
│   ├── JwtService
│   ├── SecurityConfiguration
│   └── WebSocketConfig
├── controller
│   ├── ChatRoomController
│   ├── MessageController
│   ├── UserController
│   └── WebSocketController
├── demo
│   └── DemoController
├── dto
│   ├── ChatRoomDto
│   ├── MessageDto
│   └── UsersDto
├── mapper
│   ├── impl
│   │   └── UserMapperImpl
│   ├── ChatRoomMapper
│   ├── MessageMapper
│   └── UserMapper
├── model
│   ├── ChatRoom
│   ├── ChatRoomType
│   ├── Message
│   ├── Permission
│   ├── RequestMessage
│   ├── Role
│   └── User
├── repository
│   ├── ChatRoomRepository
│   ├── MessageRepository
│   ├── PermissionRepository
│   └── UserRepository
├── services
│   ├── impl
│   │   ├── ChatRoomServiceImpl
│   │   ├── MessageServiceImpl
│   │   └── UserServiceImpl
│   ├── ChatRoomService
│   ├── MessageService
│   └── UserService
└── DemoApplication

resources
├── db.migration
│   ├── V1__create_user_table.sql
│   ├── V2__create_chatroom_table.sql
│   ├── V3__create_message_table.sql
│   ├── V4__create_chatroom_users_table.sql
│   ├── V5__create_permission_table.sql
│   └── V6__create_user_permissions_table.sql
├── static
├── templates
└── application.yml

test
└── java
    └── resources

docker-compose.yaml
Dockerfile
```

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- Docker
- Docker Compose

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/Buzhukovv/spring_boot_User_Task_Test.git
    cd spring_boot_User_Task_Test
    ```

2. **Create a `Dockerfile` in the root of your project:**
    ```dockerfile
    # Use the official Maven image to build the application
    FROM maven:3.8.4-jdk-11 as build

    # Copy the source code into the image
    COPY src /home/app/src
    COPY pom.xml /home/app

    # Package the application
    RUN mvn -f /home/app/pom.xml clean package

    # Use OpenJDK for running the application
    FROM openjdk:11-jre-slim
    COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar

    # Expose port and start the application
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
    ```

3. **Create a `docker-compose.yaml` file:**
    ```yaml
    version: '3.9'
    services:
      temirlan_chat_spring:
        build: ..
        ports:
          - "8080:8080"
        environment:
          POSTGRES_URL: jdbc:postgresql://postgres:5432/course

      postgres:
        image: postgres
        ports:
          - "1111:5432"
        environment:
          POSTGRES_PASSWORD: 123456
          POSTGRES_DB: course
          POSTGRES_USER: postgres
    ```

### Running the Application

1. **Start the application:**
    ```bash
    docker-compose up --build
    ```

2. **Run the application in detached mode:**
    ```bash
    docker-compose up -d
    ```

3. **Check the logs:**
    ```bash
    docker-compose logs
    ```

4. **Stop the application:**
    ```bash
    docker-compose down
    ```

## Configuration

The application uses environment variables to configure the database connection:

- `POSTGRES_URL`:${POSTGRES_URL:jdbc:postgresql://localhost:1111/course}
- `POSTGRES_PASSWORD`: 123456
- `POSTGRES_DB`: postgres
- `POSTGRES_USER`: postgres

These variables are defined in the `docker-compose.yaml` file.

## Endpoints

Here are some of the key endpoints of the application:

- **User Registration:** `POST /api/v1/auth/register`
- **User Login:** `POST /api/v1/auth/authenticate`
- **Create Chat Room:** `POST /api/chatrooms`
- **Delete Chatroom:** `DELETE /api/chatrooms/{{id}}`
- **Send Message:** `POST /api/messages`
- **Delete Message:** `DELETE /api/messages/{{id}}`


## Troubleshooting

- **Port Conflicts:** Ensure that ports 8080 and 1111 are not being used by other applications.
- **Database Connection Issues:** Verify the database environment variables in `docker-compose.yaml`.
- **Application Logs:** Use `docker-compose logs` to check for errors and debug issues.

