package io.classroom.ClassRoom.teachers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner teacherLineRunner(TeacherRepository teacherRepository) {
        return args -> {
            Teacher aman = new Teacher(
                    "aman",
                    "vishwa",
                    "aman.lpu@gmmail.com",
                    LocalDate.of(1987, Month.APRIL, 18),
                    "maths"
            );

            Teacher shivani = new Teacher(
                    "Shivani",
                    "Mehta",
                    "shivani.mehta@school.edu",
                    LocalDate.of(1990, Month.MAY, 12),
                    "Biology"
            );

            Teacher david = new Teacher(
                    "David",
                    "Miller",
                    "david.miller@college.com",
                    LocalDate.of(1982, Month.JANUARY, 21),
                    "History"
            );

            Teacher jessica = new Teacher(
                    "Jessica",
                    "Lopez",
                    "jessica.lopez@highschool.net",
                    LocalDate.of(1985, Month.AUGUST, 30),
                    "English"
            );

            Teacher michael = new Teacher(
                    "Michael",
                    "Chen",
                    "michael.chen@university.org",
                    LocalDate.of(1989, Month.OCTOBER, 25),
                    "Computer Science"
            );

            Teacher sarah = new Teacher(
                    "Sarah",
                    "Williams",
                    "sarah.williams@middleschool.com",
                    LocalDate.of(1992, Month.DECEMBER, 7),
                    "Art"
            );

            Teacher william = new Teacher(
                    "William",
                    "Brown",
                    "william.brown@elementary.edu",
                    LocalDate.of(1988, Month.JUNE, 14),
                    "Physical Education"
            );

            teacherRepository.saveAll(
                    List.of(
                        aman, sarah, shivani, david, jessica, michael, william
                    )
            );
        };
    }
}
