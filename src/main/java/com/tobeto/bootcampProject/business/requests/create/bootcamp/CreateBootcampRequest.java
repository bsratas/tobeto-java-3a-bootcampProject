package com.tobeto.bootcampProject.business.requests.create.bootcamp;

import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.Instructor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {

    @NotEmpty(message = "Name must not be empty!")
    private String name;

    @NotNull(message = "Instructor Id must not be null!")
    private int instructorId;

    @NotNull(message = "Start Date must not be null!")
    private LocalDateTime startDate;

    @NotNull(message = "End Date must not be null!")
    private  LocalDateTime endDate;

    @NotNull(message = "Bootcamp State Id must not be null!")
    private int bootcampStateId;
}
