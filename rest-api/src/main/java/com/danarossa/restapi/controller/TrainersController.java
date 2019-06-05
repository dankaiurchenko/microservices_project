package com.danarossa.restapi.controller;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TrainersController {

    @Autowired
    private TrainersService trainersService;

    @GetMapping("/{trainerId}/realized-courses")
    public Iterable<RealizedCourse> realizedCoursesOfLecturer(@PathVariable Integer trainerId) {
        return trainersService.realizedCoursesOfLecturer(trainerId);
    }

    @GetMapping("/{trainerId}/courses")
    public Iterable<Course> coursesOfLecturer(@PathVariable Integer trainerId) {
        return trainersService.coursesOfLecturer(trainerId);
    }

    @GetMapping
    public Iterable<User> allTrainers() {
        return trainersService.allTrainers();
    }

}


