package com.danarossa.restapi.controller;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.dto.ArchiveItem;
import com.danarossa.restapi.dto.StudentWithMark;
import com.danarossa.restapi.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public Iterable<User> allStudents() {
        return studentsService.allStudents();
    }

    @GetMapping("/{studentId}/courses")
    public Iterable<Course> allOfStudent(@PathVariable Integer studentId) {
        return studentsService.allOfStudent(studentId);
    }

    @GetMapping("/{studentId}/trainers")
    public List<StudentWithMark> allTrainersOfStudent(@PathVariable Integer studentId) {
        return studentsService.allTrainersOfStudent(studentId);
    }


    @GetMapping("/{studentId}/realized-courses")
    public Iterable<RealizedCourse> coursesOfStudent(@PathVariable Integer studentId) {
        return studentsService.coursesOfStudent(studentId);
    }

    @GetMapping("/{studentId}/marks")
    public List<ArchiveItem> marksOfStudent(@PathVariable Integer studentId) {
        return studentsService.marksOfStudent(studentId);
    }

}
