package com.tobeto.bootcampProject.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity <T>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private T id;

    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Column(name="updatedDate")
    private LocalDateTime updatedDate;

    @Column (name="deletedDate")
    private LocalDateTime deletedDate;
}
