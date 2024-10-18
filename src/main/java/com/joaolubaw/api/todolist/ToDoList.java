package com.joaolubaw.api.todolist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ToDoList {
    private List<Task> tasks;
    private static final String FILE_NAME = "todolist.json";

    public ToDoList() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public Task addTask(String taskText) {
        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        Task temp = new Task(newId, taskText);
        tasks.add(temp);
        saveTasks();
        return  temp;
    }

    public boolean removeTask(int taskId) {
        boolean removed = tasks.removeIf(task -> task.getId() == taskId);
        saveTasks();
        return removed;
    }

    public Task concludeTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
               task.setConcluded(true);
               return getTaskById(taskId);
        }
    }
    saveTasks();
    return null;
    }

    public Task editTask(int taskId, String newText) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setText(newText);
                saveTasks();
                return getTaskById(taskId);
            }
        }
        return null;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void saveTasks() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type taskListType = new TypeToken<ArrayList<Task>>() {}.getType();
            tasks = gson.fromJson(reader, taskListType);

            if(tasks == null) {
                tasks = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            tasks = new ArrayList<>();
        }
    }
}
