package com.joaolubaw.api.todolist;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Exercise 4: To-do List")
public class ToDoListController {
    private final ToDoList toDoList;

    public ToDoListController() {
        this.toDoList = new ToDoList();
    }

    @Operation(summary = "See", description = "See tasks")
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = toDoList.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Add", description = "Add new task")
    @PostMapping
    public ResponseEntity<Task> addTask(
            @Schema(type = "object", example = "{\"taskText\": \"Task text\"}", description = "JSON object containing taskText")
            @RequestBody Map<String, String> requestBody) {
        String taskText = requestBody.get("taskText");
        Task addedTask = toDoList.addTask(taskText);
        return ResponseEntity.ok(addedTask);
    }

    @Operation(summary = "Remove", description = "Remove a task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task removed",
                    content = @Content(schema = @Schema(type = "string", example = "Task removed"))),
            @ApiResponse(responseCode = "404", description = "This task does not exist",
                    content = @Content(schema = @Schema(type = "string", example = "Task not found")))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@Parameter(name = "id", description = "ID of the task to be deleted", example = "1")
                                             @PathVariable(value = "id") int id) {
        boolean removed = toDoList.removeTask(id);
        return removed ? ResponseEntity.ok("Task successfully removed") :
                ResponseEntity.status(404).body("Task not found");
    }

    @Operation(summary = "Conclude", description = "Conclude a task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task concluded",
                    content = @Content(schema = @Schema(type = "string", example = "Task concluded"))),
            @ApiResponse(responseCode = "404", description = "This task does not exist",
                    content = @Content(schema = @Schema(type = "string", example = "Task not found")))
    })
    @PutMapping("/{id}/conclude")
    public ResponseEntity<Task> concludeTask(@Parameter(name = "id", description = "ID of the task to be concluded", example = "1")
                                             @PathVariable(value = "id") int id) {
        Task concludedTask = toDoList.concludeTask(id);

        return concludedTask != null ? ResponseEntity.ok(concludedTask) :
                ResponseEntity.status(404).body(null);
    }

    @Operation(summary = "Edit", description = "Edit a task's text")@ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "This task does not exist",
                    content = @Content(schema = @Schema(type = "string", example = "Task not found")))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> editTask(@Parameter(name = "id", description = "ID of the task to be edited", example = "1")
                                         @PathVariable(value = "id") int id ,
                                         @Schema(type = "object", example = "{\"taskText\": \"Task text\"}", description = "JSON object containing taskText")
                                         @RequestBody Map<String, String> requestBody) {
        String taskText = requestBody.get("taskText");
        Task updatedTask = toDoList.editTask(id, taskText);
        return updatedTask != null ?
                ResponseEntity.ok(updatedTask) :
                ResponseEntity.status(404).body(null);
    }
}
