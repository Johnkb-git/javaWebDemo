package com.amazon.starter.domain;

import javax.persistence.Id;

import javax.persistence.*;

/**
 * @author: John Zhang
 * @date: 1/17/20
 * @decription:
 **/
@Entity
@Table(name = "USER_DATA")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_Email")
    private String email;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
