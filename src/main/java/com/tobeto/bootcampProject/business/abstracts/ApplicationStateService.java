package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.tobeto.bootcampProject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicationState.GetAllApplicationStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.applicationState.GetApplicationStateByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.applicationState.UpdateApplicationStateResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<CreateApplicationStateResponse> createApplicationState(CreateApplicationStateRequest request);

    DataResult<List<GetAllApplicationStatesResponse>> getAllStates();

    DataResult<GetApplicationStateByIdResponse> getApplicationState(int id);
    DataResult<UpdateApplicationStateResponse> updateApplicationState(UpdateApplicationStateRequest request);

    DataResult<List<GetAllApplicationStatesResponse>> getAllSorted(PageDto pageDto);
    Result deleteApplicationState(int id);
}
