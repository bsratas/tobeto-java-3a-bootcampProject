package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="blacklists")
public class Blacklist extends BaseEntity<Integer> {

    @Column(name="reason")
    private String reason;

    @Column(name="date")
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="applicantId")
    private Applicant applicant;
}
