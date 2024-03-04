package com.tobeto.bootcampProject.core.utilities.results;

import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;

import java.util.List;

public class SuccessDataResult<T> extends DataResult{
    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data, boolean success) {
        super(data, true);
    }

    public SuccessDataResult(String message){
        super(null, true, message);
    }

    public SuccessDataResult(List<GetAllApplicantResponse> responses){
        super(null, true);
    }
}
