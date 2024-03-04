package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcampState.GetBootcampStateById;
import com.tobeto.bootcampProject.business.responses.update.bootcampState.UpdateBootcampStateResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> createBootcampState(CreateBootcampStateRequest request);

    DataResult<List<GetAllBootcampStatesResponse>> getAllBootcampStates();

    DataResult<GetBootcampStateById> getBootcampState(int id);

    DataResult<UpdateBootcampStateResponse> updateBootcampState(UpdateBootcampStateRequest request);

    DataResult<List<GetAllBootcampStatesResponse>> getAllSorted(PageDto pageDto);

    Result deleteBootcampState(int id);

}
