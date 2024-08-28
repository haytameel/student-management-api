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
            Student marcos = new Student(1L, "Marcos", "marcos@gmail.com", LocalDate.of(1999, Month.DECEMBER, 8));
            Student haytam = new Student("Haytam", "hayta@gmail.com", LocalDate.of(2004, Month.DECEMBER, 22));

                    repository.saveAll(List.of(marcos,haytam));


        };
    }


}
