package com.tobeto.bootcampProject.business.responses.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInstructorByIdResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String companyName;
    private LocalDateTime dateOfBirth;
}
