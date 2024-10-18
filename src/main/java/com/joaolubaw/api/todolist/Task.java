package com.joaolubaw.api.todolist;

public class Task {
    private int id;
    private String text;
    private boolean concluded;

    public Task(int id, String text) {
        this.id = id;
        this.text = text;
        this.concluded = false;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", concluded=" + concluded +
                '}';
    }
}
