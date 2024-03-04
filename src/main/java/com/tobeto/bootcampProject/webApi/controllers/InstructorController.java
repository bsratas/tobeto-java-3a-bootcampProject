package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController extends BaseController{
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody @Valid CreateInstructorRequest request){
        return handleDataResult(instructorService.createInstructor(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors(){
        return handleDataResult(instructorService.getAllInstructor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable int id){
        return handleDataResult(instructorService.getInstructor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@RequestBody @Valid UpdateInstructorRequest request, @PathVariable int id){
        return handleDataResult(instructorService.updateInstructorById(request, id));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(@RequestBody PageDto pageDto){
        return handleDataResult(instructorService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable int id){
        return handleResult(instructorService.deleteInstructorById(id));
    }

}
