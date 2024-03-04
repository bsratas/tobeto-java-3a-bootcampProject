package com.tobeto.bootcampProject.business.responses.create.blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistResponse {
    private int id;
    private String reason;
    private LocalDateTime date;
    private int applicantId;
    private String applicantFirstName;
    private String applicantEmail;
}
