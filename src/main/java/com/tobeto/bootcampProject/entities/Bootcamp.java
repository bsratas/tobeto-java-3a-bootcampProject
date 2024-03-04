package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcamps")
public class Bootcamp extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private  LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "bootcampStateId")
    private BootcampState bootcampState;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;


}
