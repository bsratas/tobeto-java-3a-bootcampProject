package com.tobeto.bootcampProject.dataAccess.abstracts;

import com.tobeto.bootcampProject.entities.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState, Integer> {
}
