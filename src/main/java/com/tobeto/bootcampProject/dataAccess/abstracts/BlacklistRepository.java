package com.tobeto.bootcampProject.dataAccess.abstracts;

import com.tobeto.bootcampProject.entities.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {
    Blacklist findById(int id);
    Blacklist getByApplicantId(int applicant_id);
}
