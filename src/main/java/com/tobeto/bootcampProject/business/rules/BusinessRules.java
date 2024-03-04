package com.tobeto.bootcampProject.business.rules;

import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.User;
import org.springframework.stereotype.Service;

@Service
public class BusinessRules {

    public static Result run(Result... rules) {
        for (var rule : rules) {

            if (!rule.isSuccess()) {
                return rule;
            }
        }
        return null;
    }

}
