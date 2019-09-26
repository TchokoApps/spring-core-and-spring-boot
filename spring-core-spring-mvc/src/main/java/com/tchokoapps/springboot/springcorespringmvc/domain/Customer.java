package com.tchokoapps.springboot.springcorespringmvc.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Customer() {
    }

}
