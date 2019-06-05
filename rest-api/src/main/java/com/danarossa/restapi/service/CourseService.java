package com.danarossa.restapi.service;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;

public interface CourseService {
    Iterable<Course> all();

    Integer add(Course courseCourse);

    void edit(Course[] courses);

    void editOne(Course course);

    void delete(Course[] courses);

    void deleteOne(Course course);

    Course byId(Integer courseId);

    Iterable<RealizedCourse> allOfCourse(Integer courseId);
}
