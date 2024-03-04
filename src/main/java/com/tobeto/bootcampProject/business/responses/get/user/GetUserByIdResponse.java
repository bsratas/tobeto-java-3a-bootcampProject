package com.tobeto.bootcampProject.business.responses.get.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
