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
   git clone https://github.com/yourusername/your-repo.git
2. Navigate to the rectangles folder and compile the Java project
    ```bash
    javac -d bin src/main/java/com/joaolubaw/rectangles/*.java

3. Run the application:
    ```bash
    java -cp bin com.joaolubaw.rectangles.Main

## API - (Exercises 1, 4, 5, and 6)

**Description**

This Spring Boot-based API combines the resolution of exercises 1, 4, 5, and 6. It exposes a variety of endpoints with a user-friendly Swagger UI for ease of use.

**How to Build and Run:**
1. Ensure you have cloned the repository.
2. Navigate to the API project directory and run the Spring Boot application:
    ```bash
    mvn spring-boot:run
3. Access the Swagger UI for interacting with the API:
http://localhost:8080/swagger-ui/index.html#/

![Application Running](https://link-do-seu-gif.gif 9 )


### API Endpoints Overview 

#### 1: A CNPJ Validator
Given a string, the API checks if a CNPJ is well-formed and verifies if it is already linked to a company.

The API can handle two formats:"00.000.000/0000-00" and "00000000000000"

    POST /validateCNPJ Body: { "cnpj": "08.730.563/0001-47" }
![Application Running](https://link-do-seu-gif.gif 1 )

#### 4: Simple Todo List
A simple backend system to manage a ToDo list, allowing you to create, retrieve, update, and delete tasks.

- Creating a Task: POST request with the task's description.
![Application Running](https://link-do-seu-gif.gif 4 )

- Retrieving Tasks: GET request to list all tasks.
![Application Running](https://link-do-seu-gif.gif 5 )

- Deleting a Task: DELETE request with the task ID.
![Application Running](https://link-do-seu-gif.gif 6 )

- Updating a Task: PUT request with the task ID and new description.
![Application Running](https://link-do-seu-gif.gif 7 )

- Marking a Task as Completed: PUT request with the task ID to mark it as complete.
![Application Running](https://link-do-seu-gif.gif 8 )

#### 5: Rest Client - World Clock
This API consumes an external service to get the current UTC date/time and displays it alongside the local date/time, both already formatted.

![Application Running](https://link-do-seu-gif.gif 2)


#### 6: Rest Server - World Clock
Now it is the opposite, now we are the rest server, providing the current time in UTC and Local timezones, but in normal format now ("2019-08-12T14:40Z")

![Application Running](https://link-do-seu-gif.gif 3)

### Exercise 7
A simple Order Manager System ER model.
Also, annotations about a way to order orders by number of items and also the best indexes for every relevant table.

![Image](https://link-do-seu-gif.gif img)

## Final Message

I just want to thank you guys for this opportunity. This challenge not only improved my skills but also pushed me beyond my limits as I worked hard to meet the deadline. It was both a challenging and fun experience, and I truly appreciate the chance to participate of this process. I hope we can stay in touch:)