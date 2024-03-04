package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.core.utilities.results.Result;

public interface BaseService {
    Result checkIfUserExists(String email);

    Result isUsernameAlreadyTaken(String username);
}
