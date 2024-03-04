package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface UserService {

    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<GetUserByEmailResponse> getUserByEmail(String email);

    DataResult<List<GetAllUserResponse>> getAllSorted(PageDto pageDto);

}
