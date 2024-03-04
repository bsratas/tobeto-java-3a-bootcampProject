package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.applications.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetApplicationByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> createApplication(CreateApplicationRequest request);

    DataResult<List<GetAllApplicationsResponse>> getAllApplications();
    DataResult<GetApplicationByIdResponse> getApplication(int id);

    DataResult<UpdateApplicationResponse> updateApplication(UpdateApplicationRequest request);

    DataResult<List<GetAllApplicationsResponse>> getAllSorted(PageDto pageDto);

    Result deleteApplication(int id);
 }
