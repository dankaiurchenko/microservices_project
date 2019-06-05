package com.danarossa.restapi.service.implementation;

import com.danarossa.restapi.data.*;
import com.danarossa.restapi.dto.ArchiveItem;
import com.danarossa.restapi.dto.StudentWithMark;
import com.danarossa.restapi.repository.CourseRepository;
import com.danarossa.restapi.repository.RealizedCourseRepository;
import com.danarossa.restapi.repository.StudentsCourseRepository;
import com.danarossa.restapi.repository.UserRepository;
import com.danarossa.restapi.service.ServiceException;
import com.danarossa.restapi.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RealizedCourseRepository realizedCourseRepository;
    @Autowired
    private StudentsCourseRepository studentsCourseRepository;


    @Override
    public Iterable<User> allStudents() {
        return userRepository.findByRole(Role.STUDENT);
    }

    @Override
    public Iterable<Course> allOfStudent(Integer studentId) {
        return courseRepository.findByStudentId(studentId);
    }

    @Override
    public List<StudentWithMark> allTrainersOfStudent(Integer studentId) {
        return userRepository.getAllLecturersForStudent(studentId);
    }


    @Override
    public Iterable<RealizedCourse> coursesOfStudent(Integer studentId) {
        return realizedCourseRepository.findByStudentId(studentId);
    }

    @Override
    public List<ArchiveItem> marksOfStudent(Integer studentId) {
        List<ArchiveItem> archiveItems = new ArrayList<>();
        List<StudentsCourse> StudentsCoursesForStudent = studentsCourseRepository.findByStudentId(studentId);
        for (StudentsCourse StudentsCourse : StudentsCoursesForStudent) {
            Course course = courseRepository.findByRealizedCourseId(StudentsCourse.getRealizedCourseId())
                    .orElseThrow(() -> new ServiceException("Course not found"));
            RealizedCourse realizedCourse = realizedCourseRepository
                    .findById(StudentsCourse.getRealizedCourseId())
                    .orElseThrow(() -> new ServiceException("RealizedCourse not found"));
            User user = userRepository.findById(course.getLecturerId())
                    .orElseThrow(() -> new ServiceException("User not found"));
            archiveItems.add(new ArchiveItem(StudentsCourse.getStudentCourseId(), course.getTitle(),
                    StudentsCourse.getRealizedCourseId(),
                    user.getName() + " " + user.getSurname(),
                    realizedCourse.getEndDate(), StudentsCourse.getMark()));
        }

        return archiveItems;
    }
}
