package com.github.nuromirzak.todo_backend;

import com.github.nuromirzak.todo_backend.todo_item.TodoItem;
import com.github.nuromirzak.todo_backend.todo_item.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(@Autowired TodoItemRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new TodoItem("Solve daily leetcode problem", true)));
            log.info("Preloading " + repository.save(new TodoItem("Read a book")));
            log.info("Preloading " + repository.save(new TodoItem("Walk the dog")));
            log.info("Preloading " + repository.save(new TodoItem("Do the \"Introducing to Computer Science\" homework")));
            log.info("Preloading " + repository.save(new TodoItem("Message Linear Algebra teacher about the homework", true)));
        };
    }
}
