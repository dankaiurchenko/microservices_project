package com.danarossa.restapi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students_courses", schema = "public", catalog = "my_servlet_project")
public class StudentsCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentCourseId;
    private Integer studentId;
    private Integer realizedCourseId;
    private Integer mark;

    public StudentsCourse(Integer studentId, Integer realizedCourseId, Integer mark) {
        this.studentId = studentId;
        this.realizedCourseId = realizedCourseId;
        this.mark = mark;
    }
}
