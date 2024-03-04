package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetBlacklistByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.blacklist.UpdateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> createBlacklist(CreateBlacklistRequest request);

    DataResult<List<GetAllBlacklistResponse>> getAllBlacklist();

    DataResult<GetBlacklistByIdResponse> getBlacklistById(int id);

    DataResult<UpdateBlacklistResponse> updateBlacklist(UpdateBlacklistRequest request);

    DataResult<List<GetAllBlacklistResponse>> getAllSorted(PageDto pageDto);

    Result deleteBlacklist(int id);
}
