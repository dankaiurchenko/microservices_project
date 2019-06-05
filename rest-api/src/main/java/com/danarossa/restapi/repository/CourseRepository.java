package com.danarossa.restapi.repository;

import com.danarossa.restapi.data.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query(value = "select a.* from courses a join realized_courses b using (course_id) where b.realized_course_id = ?1", nativeQuery = true)
    Optional<Course> findByRealizedCourseId(Integer realizedCourseId);

    @Query(value = "select c.* \n" +
            "from COURSES c \n" +
            "         join REALIZED_COURSES rc using (course_id) \n" +
            "         join   STUDENTS_COURSES sc using (realized_course_id) \n" +
            "where STUDENT_ID = ?1", nativeQuery = true)
    List<Course> findByStudentId(Integer studentId);

    List<Course> findByLecturerId(Integer lecturerId);
}

