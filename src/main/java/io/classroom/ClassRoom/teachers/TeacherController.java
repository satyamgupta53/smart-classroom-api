package io.classroom.ClassRoom.teachers;

import io.classroom.ClassRoom.students.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping
    public String newTeacher(@RequestBody Teacher teacher) {
        return teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") Long id){
        return teacherService.deleteTeacher(id);
    }

    @PutMapping(path = "{teacherId}")
    public String updateTeacher(
            @PathVariable("teacherId") Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String subject
    ) {
        return teacherService.updateTeacher(id, email, subject);
    }
}
