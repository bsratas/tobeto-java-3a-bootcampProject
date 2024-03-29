package com.tobeto.bootcampProject.business.responses.get.bootcampState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampStatesResponse {
    private int id;
    private String name;
}
