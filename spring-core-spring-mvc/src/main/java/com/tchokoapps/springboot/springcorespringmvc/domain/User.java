package com.tchokoapps.springboot.springcorespringmvc.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private String username;

    @Transient
    private String password;

    private String encryptedPassword;

    private Boolean enabled = true;
}
