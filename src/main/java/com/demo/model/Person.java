package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * mcenjoy
 */
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    public Person() {}

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    //region Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", country=" + country;
    }
    //endregion
}