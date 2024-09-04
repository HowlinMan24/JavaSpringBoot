package com.demotest.entity;

import jakarta.persistence.*;


/**
 * This is an `Entity class` which has the annotation @Entity which means its like a model used for the database.
 * At the top the annotation @Table as an argument it can be given the name of the table for the model to be used.
 * The @Id attribute set to a certain variable suggests that that variable is a primary key in the table and it also auto increments.
 * The @Column attribute is set to show that the specific variable is a column in a database table, and it can have an argument name which sets
 * the name of the column in the datatable.
 * You always have a default constructor and have a constructor with arguments(This is used in a post method when creating an entity)
 * It is also advised to overload the toString() method to fit custom needs for printing the specific object.
 * Optional are the getters and setter to be implemented but if in need of modification or usage of the attributes you will need to have them
 * because the fields are private.
 */

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
