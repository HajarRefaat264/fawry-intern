package com.example.trying.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
       return args->{
          Student Hajar= new Student(
               "Hajar",
               24,
               LocalDate.of(2000, Month.APRIL,26),
               "hajarrefaat288@gmail.com"
       );
           Student Asser= new Student(
                   "Asser",
                   22,
                   LocalDate.of(2001, Month.AUGUST,26),
                   "asser@gmail.com"
           );
           Student Talia= new Student(
                   "Talia",
                   1,
                   LocalDate.of(2027, Month.APRIL,26),
                   "talia@gmail.com"
           );
           repository.saveAll(List.of(Talia,Hajar,Asser));

       };
    }
}
