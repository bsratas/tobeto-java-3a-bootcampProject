package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController extends BaseController{
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return handleDataResult(userService.getAll());
    }


    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        return handleDataResult(userService.getUserByEmail(email));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(@RequestBody PageDto pageDto){
        return handleDataResult(userService.getAllSorted(pageDto));
    }

}

