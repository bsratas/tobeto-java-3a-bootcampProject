package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicationState.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.applicationState.GetApplicationStateByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.applicationState.UpdateApplicationStateResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {

    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateApplicationStateResponse> createApplicationState(CreateApplicationStateRequest request) {
        ApplicationState applicationState = mapperService.forRequest().map(request, ApplicationState.class);
        System.out.println(applicationState);
        applicationState.setCreatedDate(LocalDateTime.now());
        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response = mapperService.forResponse().map(applicationState, CreateApplicationStateResponse.class);

        return new SuccessDataResult<CreateApplicationStateResponse>(response, "Application State Created");
    }

    @Override
    public DataResult<List<GetAllApplicationStatesResponse>> getAllStates() {

        List <ApplicationState> applicationStates = applicationStateRepository.findAll();
        List <GetAllApplicationStatesResponse> response = applicationStates.stream().map(applicationState -> mapperService.
                forResponse().map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationStatesResponse>>(response, "All Application States Listed");
    }

    @Override
    public DataResult<GetApplicationStateByIdResponse> getApplicationState(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        GetApplicationStateByIdResponse response = mapperService.forResponse().map(applicationState, GetApplicationStateByIdResponse.class);
        return new SuccessDataResult<GetApplicationStateByIdResponse>(response, "Application State Listed");

    }

    @Override
    public DataResult<UpdateApplicationStateResponse> updateApplicationState(UpdateApplicationStateRequest request) {
        ApplicationState applicationState = mapperService.forRequest().map(request, ApplicationState.class);
        ApplicationState updatedApplicationState = applicationStateRepository.save(applicationState);

        UpdateApplicationStateResponse response = mapperService.forResponse().map(updatedApplicationState, UpdateApplicationStateResponse.class);

        return new SuccessDataResult<UpdateApplicationStateResponse>(response, "Application State Updated");
    }

    @Override
    public DataResult<List<GetAllApplicationStatesResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<ApplicationState> applicationStates = applicationStateRepository.findAll(pageable);
        List <GetAllApplicationStatesResponse> response = applicationStates.stream().map(applicationState -> mapperService.forResponse().map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationStatesResponse>>(response, "All Applicant States Sorted");
    }

    @Override
    public Result deleteApplicationState(int id) {
        applicationStateRepository.deleteById(id);
        return new SuccessResult("Application State Deleted");
    }
}
