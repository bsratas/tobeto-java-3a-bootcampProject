package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.applications.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetApplicationByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetBlacklistByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Application;
import com.tobeto.bootcampProject.entities.Blacklist;
import com.tobeto.bootcampProject.entities.Employee;
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
public class ApplicationManager implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;
    private BlacklistRepository blacklistRepository;
    private BlacklistManager blacklistManager;

    @Override
    public DataResult<CreateApplicationResponse> createApplication(CreateApplicationRequest request) {
        System.out.println(request.getApplicantId());

        Application application = mapperService.forRequest().map(request, Application.class);
        System.out.println(application.getApplicant());
        application.setCreatedDate(LocalDateTime.now());
        applicationRepository.save(application);

        CreateApplicationResponse response = mapperService.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>(response, "Application Created");
    }

    @Override
    public DataResult<List<GetAllApplicationsResponse>> getAllApplications() {
        List <Application> applications = applicationRepository.findAll();
        List <GetAllApplicationsResponse> response = applications.stream().map(application -> mapperService.
                forResponse().map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationsResponse>>(response, "All Applications Listed");
    }

    @Override
    public DataResult<GetApplicationByIdResponse> getApplication(int id) {

        Application application = applicationRepository.findById(id).orElseThrow();
        GetApplicationByIdResponse response = mapperService.forResponse().map(application, GetApplicationByIdResponse.class);
        return new SuccessDataResult<GetApplicationByIdResponse>(response, "Application Listed");
    }

    @Override
    public DataResult<UpdateApplicationResponse> updateApplication(UpdateApplicationRequest request) {
        Application application = mapperService.forRequest().map(request, Application.class);
        Application updatedApplication = applicationRepository.save(application);

        UpdateApplicationResponse response = mapperService.forResponse().map(updatedApplication, UpdateApplicationResponse.class);

        return new SuccessDataResult<UpdateApplicationResponse>(response, "Application Updated");
    }

    @Override
    public DataResult<List<GetAllApplicationsResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Application> applications = applicationRepository.findAll(pageable);
        List <GetAllApplicationsResponse> response = applications.stream().map(application -> mapperService.forResponse().map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationsResponse>>(response, "All Applications Sorted");
    }


    @Override
    public Result deleteApplication(int id) {
        applicationRepository.deleteById(id);
        return new SuccessResult("Application Deleted");
    }


    public void checkIfApplicantInBlacklist(int applicantIdInApplication) {
        DataResult<GetBlacklistByIdResponse> blacklist = blacklistManager.getBlacklistById(applicantIdInApplication);
        //System.out.println(blacklist);
        if(blacklist.isSuccess() == true){
            throw new BusinessException("You Are In The Blacklist!");
        }
    }

    public void checkIfApplicantInBlacklistSecond(int applicantIdInApplication) {
        Blacklist blacklist = blacklistRepository.getByApplicantId(applicantIdInApplication);
        System.out.println(blacklist);
        if(blacklist != null){
            throw new BusinessException("You Are In The Blacklist!");
        }
    }

}


