package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applications")
public class Application extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "applicationStateId")
    private ApplicationState applicationState;


}
