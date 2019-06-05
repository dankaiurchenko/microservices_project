package com.danarossa.restapi.service;

import com.danarossa.restapi.data.Course;
import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.dto.ArchiveItem;
import com.danarossa.restapi.dto.StudentWithMark;

import java.util.List;

public interface StudentsService {
    Iterable<User> allStudents();

    Iterable<Course> allOfStudent(Integer studentId);

    List<StudentWithMark> allTrainersOfStudent(Integer studentId);

    Iterable<RealizedCourse> coursesOfStudent(Integer studentId);

    List<ArchiveItem> marksOfStudent(Integer studentId);
}
