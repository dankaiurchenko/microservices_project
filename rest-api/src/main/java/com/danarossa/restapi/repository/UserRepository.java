package com.danarossa.restapi.repository;

import com.danarossa.restapi.data.Role;
import com.danarossa.restapi.data.User;
import com.danarossa.restapi.dto.StudentWithMark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findByRole(Role student);

    @Query(value = "select a.* from " +
            "  users a join students_courses b on a.user_id = b.student_id where b.realized_course_id = ?1",
            nativeQuery = true)
    List<User> findStudentsByRealizedCourseId(Integer realizedCourseId);

    @Query(value = "select USER_ID, EMAIL, PASSWORD, NAME, SURNAME, DATE_ENTERED, ROLE " +
            "  from student_lecturers_view where STUDENT_ID = ?1", nativeQuery = true)
    List<StudentWithMark> getAllLecturersForStudent(Integer studentId);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

