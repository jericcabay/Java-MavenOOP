package com.example.demo.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator (
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient // The Age display in website but not in DATABASE
    private int age;

    public Student() {

    }

    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(int i, long l, String jericCabay, String mail, LocalDate of, int i1) {
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this .name = name;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears(); // Calculate the of using LOCALDATE
    }

    public String toString() {
        return "Student{" +
                "Id: " + id + '\n' +
                "Name: '" + name + '\'' +
                "Email: '" + email + '\'' +
                "Dob: " + dob +
                "Age: " + age +
                "}";
    }
}
