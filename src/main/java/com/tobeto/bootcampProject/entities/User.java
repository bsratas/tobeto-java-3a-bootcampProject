package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<Integer> {

    @Column(name="userName")
    private String userName;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="dateOfBirth")
    private Date dateOfBirth;

    @Column(name="nationalIdentity")
    private String nationalIdentity;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;



}
