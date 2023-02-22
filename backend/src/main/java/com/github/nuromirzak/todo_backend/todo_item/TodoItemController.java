package com.github.nuromirzak.todo_backend.todo_item;

import com.github.nuromirzak.todo_backend.todo_item.exceptions.TodoItemNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todo")
public class TodoItemController {
    TodoItemService service;

    @GetMapping("/all")
    public List<TodoItem> getAll(@RequestParam(value = "status", required = false, defaultValue = "ALL") TodoStatus status) {
        return service.findAll(status);
    }

    @GetMapping("/{id}")
    public TodoItem get(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
    }

    @PostMapping("/save")
    public TodoItem save(@Valid @RequestBody TodoItem todoItem) {
        return service.saveOrUpdateTodoItem(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable Long id, @Valid @RequestBody TodoItem todoItemDetails) {
        TodoItem todoItem = service.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));

        todoItem.setDescription(todoItemDetails.getDescription());
        todoItem.setDone(todoItemDetails.getDone());

        service.saveOrUpdateTodoItem(todoItem);

        return todoItem;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        TodoItem todoItem = service.findById(id).
                orElseThrow(() -> new TodoItemNotFoundException(id));

        return service.deleteById(todoItem.getId());
    }

    @Autowired
    public void setService(TodoItemService service) {
        this.service = service;
    }
}
