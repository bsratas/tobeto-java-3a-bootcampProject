package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{
    private BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<?> createBlacklist(@RequestBody @Valid CreateBlacklistRequest request){
        return handleDataResult(blacklistService.createBlacklist(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBlacklists(){
        return handleDataResult(blacklistService.getAllBlacklist());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlacklist(@PathVariable int id){
        return handleDataResult(blacklistService.getBlacklistById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBlacklist(@RequestBody @Valid UpdateBlacklistRequest request){
        return handleDataResult(blacklistService.updateBlacklist(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllBlacklists(@RequestBody PageDto pageDto){
        return handleDataResult(blacklistService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlacklist(@PathVariable int id){
        return handleResult(blacklistService.deleteBlacklist(id));
    }

}
