package io.classroom.ClassRoom.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner studentLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student satyam = new Student(
                    "Satyam",
                    "Gupta",
                    "satyam.gupta@gmail.com",
                    LocalDate.of(2003, Month.AUGUST, 30)

            );

            Student alice = new Student(
                    "Alice",
                    "Johnson",
                    "alice.johnson@school.edu",
                    LocalDate.of(2005, Month.FEBRUARY, 10)
            );

            Student ben = new Student(
                    "Ben",
                    "Miller",
                    "ben.miller@hotmail.com",
                    LocalDate.of(2002, Month.SEPTEMBER, 25)
            );

            Student chloe = new Student(
                    "Chloe",
                    "Garcia",
                    "chloegarcia@yahoo.com",
                    LocalDate.of(2004, Month.DECEMBER, 1)
            );

            Student david = new Student(
                    "David",
                    "Lee",
                    "david.lee@student.com",
                    LocalDate.of(2006, Month.JANUARY, 8)
            );

            Student emily = new Student(
                    "Emily",
                    "Hernandez",
                    "emilyh@university.org",
                    LocalDate.of(2001, Month.JULY, 14)
            );

            Student ryan = new Student(
                    "Ryan",
                    "Thompson",
                    "ryan.thompson123@gmail.com",
                    LocalDate.of(2003, Month.APRIL, 2)
            );

            Student sofia = new Student(
                    "Sofia",
                    "Lopez",
                    "sofial@college.edu",
                    LocalDate.of(2005, Month.OCTOBER, 21)
            );

            Student michael = new Student(
                    "Michael",
                    "Williams",
                    "michael.w@studentmail.com",
                    LocalDate.of(2002, Month.JUNE, 19)
            );

            Student olivia = new Student(
                    "Olivia",
                    "Jones",
                    "olivia.jones@school.net",
                    LocalDate.of(2004, Month.MAY, 5)
            );

            Student william = new Student(
                    "William",
                    "Brown",
                    "william.brown789@gmail.com",
                    LocalDate.of(2006, Month.NOVEMBER, 30)
            );

            studentRepository.saveAll(
                    List.of(satyam, alice, ben, chloe, david, emily, ryan, sofia, michael, olivia, william)
            );
        };
    }
}
