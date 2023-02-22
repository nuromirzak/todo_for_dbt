package com.github.nuromirzak.todo_backend.todo_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {
    TodoItemRepository repository;

    public TodoItem saveOrUpdateTodoItem(TodoItem todoItem) {
        return repository.save(todoItem);
    }

    public Optional<TodoItem> findById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    public List<TodoItem> findAll(TodoStatus status) {
        if (status == TodoStatus.ALL) {
            return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        } else if (status == TodoStatus.ACTIVE) {
            return repository.findTodoItemsByDoneOrderById(false);
        } else {
            return repository.findTodoItemsByDoneOrderById(true);
        }
    }

    @Autowired
    public void setRepository(TodoItemRepository repository) {
        this.repository = repository;
    }
}
