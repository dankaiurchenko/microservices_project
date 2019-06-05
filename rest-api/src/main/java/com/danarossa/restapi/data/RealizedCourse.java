package com.danarossa.restapi.data;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "realized_courses", schema = "public", catalog = "my_servlet_project")
public class RealizedCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer realizedCourseId;
    @Column(name = "course_id")
    private Integer courseId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp examDate;
    private String status;

    @ManyToOne()
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

}
