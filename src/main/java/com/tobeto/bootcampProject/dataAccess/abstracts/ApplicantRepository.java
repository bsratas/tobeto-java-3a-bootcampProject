package com.tobeto.bootcampProject.dataAccess.abstracts;

import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    Applicant findByEmail(String email);

    Applicant findByUserName(String username);
}
