package com.danarossa.restapi.service.implementation;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.data.Role;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.repository.CourseRepository;
import com.danarossa.restapi.repository.RealizedCourseRepository;
import com.danarossa.restapi.repository.UserRepository;
import com.danarossa.restapi.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainersServiceImpl implements TrainersService {

    @Autowired
    private RealizedCourseRepository realizedCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<RealizedCourse> realizedCoursesOfLecturer(Integer trainerId) {
        return realizedCourseRepository.findByLecturerId(trainerId);
    }

    @Override
    public Iterable<Course> coursesOfLecturer(Integer trainerId) {
        return courseRepository.findByLecturerId(trainerId);
    }

    @Override
    public Iterable<User> allTrainers() {
        return userRepository.findByRole(Role.TRAINER);
    }
}
