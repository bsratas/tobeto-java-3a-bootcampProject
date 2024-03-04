package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcampStates")
@EqualsAndHashCode(callSuper = true)
public class BootcampState extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "bootcampState")
    private List<Bootcamp> bootcamps;

}
