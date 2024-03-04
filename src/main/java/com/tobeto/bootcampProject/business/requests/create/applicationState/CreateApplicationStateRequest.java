package com.tobeto.bootcampProject.business.requests.create.applicationState;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationStateRequest {

    @NotEmpty(message = "Name must not be empty!")
    private String name;
}
