package com.danarossa.restapi.repository;

import com.danarossa.restapi.data.StudentsCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsCourseRepository extends CrudRepository<StudentsCourse, Integer> {

    Optional<StudentsCourse> findByStudentIdAndRealizedCourseId(Integer studentId, Integer realizedCourseId);

    List<StudentsCourse> findByStudentId(Integer studentId);
}
