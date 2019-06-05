package com.danarossa.restapi.service.implementation;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.repository.CourseRepository;
import com.danarossa.restapi.repository.RealizedCourseRepository;
import com.danarossa.restapi.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CourseServiceImpl implements com.danarossa.restapi.service.CourseService {
    @Autowired
    private RealizedCourseRepository realizedCourseRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Iterable<Course> all() {
        return courseRepository.findAll();
    }

    @Override
    public Integer add(Course courseCourse) {
        courseRepository.save(courseCourse);
        return courseCourse.getCourseId();
    }

    @Override
    public void edit(Course[] courses) {
        Arrays.stream(courses).forEach(courseRepository::save);
    }

    @Override
    public void editOne(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(Course[] courses) {
        Arrays.stream(courses).forEach(courseRepository::delete);
    }

    @Override
    public void deleteOne(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course byId(Integer courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new ServiceException("Course not found"));
    }

    @Override
    public Iterable<RealizedCourse> allOfCourse(Integer courseId) {
        return realizedCourseRepository.findByCourseId(courseId);

    }
}