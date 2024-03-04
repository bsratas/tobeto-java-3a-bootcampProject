package com.tobeto.bootcampProject.business.responses.get.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
