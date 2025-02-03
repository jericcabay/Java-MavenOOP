package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student jeric = new Student(
                    // ADD ID IF THE ID IS NOT AUTO INCREMENT OR NOT IN PRIMARY KEY IF SET IN PRIMARY OR AUTO DO NOT ADD
                    "Jeric",
                    "example@example.com",
                    LocalDate.of(2000, Month.MARCH, 1)
            );
            Student cabay = new Student(
                    // ID
                    "Cabay",
                    "example11@example.com",
                    LocalDate.of(1999, Month.APRIL, 2)
            );

            repository.saveAll(
                    List.of(jeric, cabay));
        };
    }
}
