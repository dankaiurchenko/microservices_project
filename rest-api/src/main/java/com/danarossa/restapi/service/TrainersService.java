package com.danarossa.restapi.service;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.data.User;

public interface TrainersService {
    Iterable<RealizedCourse> realizedCoursesOfLecturer(Integer trainerId);

    Iterable<Course> coursesOfLecturer(Integer trainerId);

    Iterable<User> allTrainers();
}
