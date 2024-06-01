package io.classroom.ClassRoom.teachers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public String addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository
                .findTeacherByEmail(teacher.getEmail());

        if(teacherOptional.isPresent()) throw new IllegalStateException("Email Already Exists !");
        teacherRepository.save(teacher);

        return "Successfully added new Teacher Details !";
    }

    public String deleteTeacher(Long id) {
        if(!teacherRepository.existsById(id))
            throw new IllegalStateException("Selected element not present !");
        else teacherRepository.deleteById(id);
        return "Successfully deleted this entry !";
    }

    @Transactional
    public String updateTeacher(Long id, String email, String subject) {
        Teacher teacher = teacherRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("ID does not exists !"));

        if(email != null  &&
                !email.isEmpty() &&
                !Objects.equals(email, teacher.getEmail())) {
            Optional<Teacher> teacherOptional = teacherRepository
                    .findTeacherByEmail(email);
            if(teacherOptional.isPresent())
                throw new IllegalStateException("Email already exists !");
            else
                teacher.setEmail(email);
        }

        if(subject != null &&
                !subject.isEmpty() &&
                !Objects.equals(subject, teacher.getSubject()))
            teacher.setSubject(subject);

        return "Updated this entry successfully !";
    }
}
