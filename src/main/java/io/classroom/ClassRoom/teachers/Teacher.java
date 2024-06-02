package io.classroom.ClassRoom.teachers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@Entity(name = "teacher")
@Table(name = "teacher")
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private long id;


    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "date_of_birth"
    )
    private LocalDate dob;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String subject;

    public Teacher() {
    }

    public Teacher(String firstName,
                   String lastName,
                   String email,
                   LocalDate dob,
                   String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", subject='" + subject + '\'' +
                '}';
    }
}
