package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicationState")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{

    private ApplicationStateService applicationStateService;
    @PostMapping
    public ResponseEntity<?> createApplicationState(@RequestBody @Valid CreateApplicationStateRequest request){
        return handleDataResult(applicationStateService.createApplicationState(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllApplicationStates(){
        return handleDataResult(applicationStateService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationState(@PathVariable int id){
        return handleDataResult(applicationStateService.getApplicationState(id));
    }

    @PutMapping
    public ResponseEntity<?> updateApplicationState(@RequestBody @Valid UpdateApplicationStateRequest request){
        return handleDataResult(applicationStateService.updateApplicationState(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(@RequestBody PageDto pageDto){
        return handleDataResult(applicationStateService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicantState(@PathVariable int id){
        return handleResult(applicationStateService.deleteApplicationState(id));
    }
}
