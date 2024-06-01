package io.classroom.ClassRoom.students;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public String addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
            throw new IllegalArgumentException("Email Already Exists !");
        studentRepository.save(student);
        return "Successfully added new student !";
    }

    public String deleteStudent(Long id) {
        if(!studentRepository.existsById(id))
            throw new IllegalStateException("Student not present !");
        studentRepository.deleteById(id);
        return "Successfully deleted this entry !";
    }

    @Transactional
    public String updateStudent(Long id, String email) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("Student not present !"));

        if(email != null &&
                !email.isEmpty() &&
                !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if(studentOptional.isPresent())
                throw new IllegalStateException("Email already exists !");
            else
                student.setEmail(email);
        }

        return "Successfully updated the email !";
    }
}
