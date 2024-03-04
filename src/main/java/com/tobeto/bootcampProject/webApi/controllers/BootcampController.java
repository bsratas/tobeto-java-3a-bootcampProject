package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampController extends BaseController{

    private BootcampService bootcampService;
    @PostMapping
    public ResponseEntity<?> createBootcamp(@RequestBody @Valid CreateBootcampRequest request){
        return handleDataResult(bootcampService.createBootcamp(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBootcamps(){
        return handleDataResult(bootcampService.getAllBootcamps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBootcampById(@PathVariable int id){
        return handleDataResult(bootcampService.getbootcamp(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBootcamp(@RequestBody @Valid UpdateBootcampRequest request){
        return handleDataResult(bootcampService.updateBootcamp(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(@RequestBody PageDto pageDto){
        return handleDataResult(bootcampService.getAllSorted(pageDto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBootcamp(@PathVariable int id){
        return handleResult(bootcampService.deleteBootcamp(id));
    }
}
