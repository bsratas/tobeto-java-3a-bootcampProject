package com.tobeto.bootcampProject.business.responses.create.applications;

import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.ApplicationState;
import com.tobeto.bootcampProject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private String applicantAbout;
    private int applicationStateId;
    private String applicantFirstName;
}
