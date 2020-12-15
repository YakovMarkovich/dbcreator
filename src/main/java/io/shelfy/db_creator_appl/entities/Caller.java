package io.shelfy.db_creator_appl.entities;

import javax.persistence.*;

@Entity
@Table(name = "callers", indexes = {@Index(columnList = "first_name, last_name", unique = true), @Index(columnList = "email", unique = true)})
public class Caller {
    @Id
    long id;
    @Column(name = "email", unique = true)
    String email;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String gender;
    String image;

    public Caller() {
    }

    public Caller(long id, String email, String firstName, String lastName, String gender, String image) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Caller{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

