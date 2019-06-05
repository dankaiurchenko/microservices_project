package com.danarossa.restapi.controller;

import com.danarossa.restapi.data.StudentsCourse;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.dto.DtoMark;
import com.danarossa.restapi.repository.StudentsCourseRepository;
import com.danarossa.restapi.repository.UserRepository;
import com.danarossa.restapi.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/marks")
public class MarkController {
    @Autowired
    private StudentsCourseRepository studentsCourseRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/student/{studentId}/course/{realizedCourseId}")
    public Optional<StudentsCourse> ofStudentAndCourse(@PathVariable("studentId") Integer studentId,
                                                       @PathVariable("realizedCourseId") Integer realizedCourseId) {
        return studentsCourseRepository.findByStudentIdAndRealizedCourseId(studentId, realizedCourseId);
    }

    @PostMapping
    public Integer addMark(@RequestBody @Valid DtoMark mark) {
        Optional<User> byId = userRepository.findById(mark.getStudentId());
        if(byId.isPresent()){
            Integer userId = byId
                    .get().getUserId();
            Integer realizedCourseId = mark.getRealizedCourseId();
            StudentsCourse StudentsCourse = new StudentsCourse(userId, realizedCourseId, mark.getMark());
            studentsCourseRepository.save(StudentsCourse);
            return StudentsCourse.getStudentCourseId();
        }else throw new RuntimeException("There is no such student!");

    }

    @PutMapping("/{markId}")
    public Integer editMark(@RequestBody @Valid DtoMark mark) {
        StudentsCourse StudentsCourse = studentsCourseRepository.findById(mark.getId()).get();
        StudentsCourse.setMark(mark.getMark());
        studentsCourseRepository.save(StudentsCourse);
        return StudentsCourse.getStudentCourseId();
    }

    @PostMapping("/join")
    public Integer joinCourse(@RequestBody @Valid DtoMark mark) {
        if (mark.getId() == null || mark.getId() == 0) {
            StudentsCourse StudentsCourse = new StudentsCourse(
                    userRepository.findById(mark.getStudentId()).get().getUserId(),
                    mark.getRealizedCourseId(), 0);
            studentsCourseRepository.save(StudentsCourse);
            return StudentsCourse.getStudentCourseId();
        } else throw new ServiceException("Student already joined the course!");
    }


}
