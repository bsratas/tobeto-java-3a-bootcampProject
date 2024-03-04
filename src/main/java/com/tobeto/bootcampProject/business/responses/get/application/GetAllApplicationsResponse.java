package com.tobeto.bootcampProject.business.responses.get.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationsResponse {
    private int id;
    private String applicantAbout;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
