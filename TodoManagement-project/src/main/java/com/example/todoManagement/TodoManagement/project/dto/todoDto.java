package com.example.todoManagement.TodoManagement.project.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class todoDto {
    private Long id;

    @NotEmpty(message = "Todo title cannot be empty")
    private String title;

    @NotEmpty(message = "Todo description cannot be empty")
    private String description;

    private boolean completed;
}
