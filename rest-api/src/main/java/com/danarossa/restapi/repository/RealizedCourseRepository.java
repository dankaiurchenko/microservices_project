package com.danarossa.restapi.repository;

import com.danarossa.restapi.data.RealizedCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealizedCourseRepository extends CrudRepository<RealizedCourse, Integer> {
    @Query(value = "select a " +
            "  from realized_courses a" +
            "  join courses using (course_id) " +
            "  where lecturer_id = ?1", nativeQuery = true)
    Iterable<RealizedCourse> findByLecturerId(Integer lecturerId);

    @Query(value = "select a.* " +
            "  from realized_courses a " +
            "  join students_courses using(realized_course_id) " +
            "  where student_id = ?1", nativeQuery = true)
    Iterable<RealizedCourse> findByStudentId(Integer studentId);

    Iterable<RealizedCourse> findByCourseId(Integer courseId);
}
