package com.github.nuromirzak.todo_backend.todo_item.exceptions;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(Long id) {
        super(String.format("Todo item with id %d not found", id));
    }
}
