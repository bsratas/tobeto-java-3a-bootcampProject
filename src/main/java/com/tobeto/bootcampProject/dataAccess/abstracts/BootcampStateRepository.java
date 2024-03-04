package com.tobeto.bootcampProject.dataAccess.abstracts;

import com.tobeto.bootcampProject.entities.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampStateRepository extends JpaRepository<BootcampState, Integer> {
}
