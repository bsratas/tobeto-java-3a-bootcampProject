package com.tobeto.bootcampProject.business.responses.get.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByEmailResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
