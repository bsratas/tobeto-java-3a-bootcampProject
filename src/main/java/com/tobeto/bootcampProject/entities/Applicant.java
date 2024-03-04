package com.tobeto.bootcampProject.entities;


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
@Table(name="applicants")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Applicant extends User{

    @Column(name="about")
    private String about;


    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;

    @OneToOne(mappedBy = "applicant")
    private Blacklist blacklist;

}
