package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<CreateApplicantResponse> createApplicant(CreateApplicantRequest request);

    DataResult<GetApplicantByIdResponse> getApplicantById(int id);

    DataResult<List<GetAllApplicantResponse>> getAllApplicant();

    DataResult<UpdateApplicantResponse> updateApplicantById(UpdateApplicantRequest request, int id);

    DataResult<List<GetAllApplicantResponse>> getAllSorted(PageDto pageDto);
    Result deleteApplicantById(int id);
}
