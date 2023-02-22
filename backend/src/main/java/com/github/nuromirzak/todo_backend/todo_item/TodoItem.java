package com.github.nuromirzak.todo_backend.todo_item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "todo_items")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "description is mandatory")
    private String description;

    private Boolean done = false;

    public TodoItem(String description) {
        this.description = description;
        this.done = false;
    }

    public TodoItem(String description, boolean done) {
        this.description = description;
        this.done = done;
    }
}
