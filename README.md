# Kaffa Mobile - Pre-qualification test

## Overview

This repository contains the resolution of the coding challenge provided by Kaffa Mobile, split into two main projects:

1. **Rectangles Intersection (Exercises 2 and 3)**: A Java command-line application that determines rectangle intersections and visualizes them on a grid.
2. **API Project (Exercises 1, 4, 5, 6)**: A RESTful API built using Spring Boot, providing functionality for validating CNPJ, managing a simple ToDo list, consuming external APIs, and exposing date/time services.

---

## Projects Overview

## Exercises 2 and 3: Rectangles Intersection

**Description**

This command-line application allows users to input coordinates for rectangles, check for intersections, and calculate the area of intersection. The results are visualized on a grid.

**Features:**

- Input coordinates for multiple rectangles.
- Visual representation of rectangles and their intersections on a grid.
- Methods to check if rectangles intersect and calculate the area of intersection.

**How to Build and Run:**

1. Clone the repository:
   ```bash
   git clone https://github.com/JoaoLubaw/codexExercise.git
   ```
2. Navigate to the rectangles folder and compile the Java project

   ```bash
   javac -d bin src/main/java/com/joaolubaw/rectangles/*.java

   ```

3. Run the application:
   ```bash
   java -cp bin com.joaolubaw.rectangles.Main
   ```

**Using**

1. When the program starts, enter the coordinates of two rectangles.
2. Enter the coordinates in the format: (x1, y1) (x2, y2), where x1, y1 represent the bottom-left corner and x2, y2 represent the top-right corner.
3. After input, the application will display a 50x50 grid where each rectangle is represented by a different letter, and intersections will be marked with #.
4. If the input is invalid (e.g., coordinates out of bounds or incorrectly ordered), you will be asked to re-enter the coordinates.
5. The intersection area will be displayed after the rectangles are processed.

![Application Running](/ReadmeMedias/9.gif)

## API - (Exercises 1, 4, 5, and 6)

**Description**

This Spring Boot-based API combines the resolution of exercises 1, 4, 5, and 6. It exposes a variety of endpoints with a user-friendly Swagger UI for ease of use.

**How to Build and Run:**

1. Ensure you have cloned the repository.
2. Navigate to the API project directory and install the Spring Boot application:
   ```bash
   mvn install
   ```
3. Run directly the .jar file:
   ```bash
   java -jar target/api-0.0.1-SNAPSHOT.jar
   ```
4. Access the Swagger UI for interacting with the API:
   http://localhost:8080/swagger-ui/index.html#/

### API Endpoints Overview

#### 1: A CNPJ Validator

Given a string, the API checks if a CNPJ is well-formed and verifies if it is already linked to a company.

The API can handle two formats:"00.000.000/0000-00" and "00000000000000"

    POST /validateCNPJ Body: { "cnpj": "08.730.563/0001-47" }

![Application Running](/ReadmeMedias/1.gif)

#### 4: Simple Todo List

A simple backend system to manage a ToDo list, allowing you to create, retrieve, update, and delete tasks.

- Creating a Task: POST request with the task's description.

      POST /tasks Body: { "taskText": "task text" }

  ![Application Running](/ReadmeMedias/4.gif)

- Retrieving Tasks: GET request to list all tasks.

      GET /tasks

  ![Application Running](/ReadmeMedias/5.gif)

- Deleting a Task: DELETE request with the task ID.

      DELETE /tasks/{id}

  ![Application Running](/ReadmeMedias/6.gif)

- Updating a Task: PUT request with the task ID and new description.

      PUT /tasks/{id} Body: { "taskText": "task text" }

  ![Application Running](/ReadmeMedias/7.gif)

- Marking a Task as Completed: PUT request with the task ID to mark it as complete.

      PUT /tasks/{id}

  ![Application Running](/ReadmeMedias/8.gif)

#### 5: Rest Client - World Clock

This API consumes an external service to get the current UTC date/time and displays it alongside the local date/time, both already formatted.

    GET /timefromexternapi

![Application Running](/ReadmeMedias/2.gif)

#### 6: Rest Server - World Clock

Now it is the opposite, now we are the rest server, providing the current time in UTC and Local timezones, but in normal format now ("2019-08-12T14:40Z")

    GET /time

![Application Running](/ReadmeMedias/3.gif)

### Exercise 7

A simple Order Manager System ER model.
Also, annotations about a way to order orders by number of items and also the best indexes for every relevant table.

![Image](/ReadmeMedias/ER_Codex.png)

## Final Message

I just want to thank you guys for this opportunity. This challenge not only improved my skills but also pushed me beyond my limits as I worked hard to meet the deadline. It was both a challenging and fun experience, and I truly appreciate the chance to participate of this process. I hope we can stay in touch:)
