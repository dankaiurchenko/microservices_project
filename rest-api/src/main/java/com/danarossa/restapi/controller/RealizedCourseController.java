package com.danarossa.restapi.controller;

import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.dto.StudentWithMark;
import com.danarossa.restapi.service.RealizedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/realized-courses")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RealizedCourseController {
    @Autowired
    private RealizedCourseService realizedCourseService;

    @GetMapping
    public Iterable<RealizedCourse> all() {
        return realizedCourseService.all();
    }


    @GetMapping("/{realizedCourseId}")
    public RealizedCourse byId(@PathVariable Integer realizedCourseId) {
        return realizedCourseService.byId(realizedCourseId);

    }

    @PostMapping
    public RealizedCourse createNew(@RequestBody @Valid RealizedCourse realizedCourse) {
        return realizedCourseService.createNew(realizedCourse);

    }

    @PutMapping
    public RealizedCourse edit(@RequestBody @Valid RealizedCourse realizedCourse) {
        return realizedCourseService.edit(realizedCourse);
    }

    @DeleteMapping("/{realizedCourseId}")
    public void delete(@PathVariable Integer realizedCourseId) {
        realizedCourseService.delete(realizedCourseId);
    }

    @GetMapping("/{realizedCourseId}/students")
    public List<StudentWithMark> allOfCourse(@PathVariable Integer realizedCourseId) {
        return realizedCourseService.allOfCourse(realizedCourseId);
    }


}
