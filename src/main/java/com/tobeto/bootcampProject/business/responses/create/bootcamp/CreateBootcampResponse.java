package com.tobeto.bootcampProject.business.responses.create.bootcamp;


import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.Instructor;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private String name;
    private int instructorId;
    private LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int bootcampStateId;
    private String instructorCompanyName;
    private String instructorFirstName;
}
