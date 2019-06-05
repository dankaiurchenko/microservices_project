package com.danarossa.restapi.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses", schema = "public", catalog = "my_servlet_project")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String title;
    private Integer numberOfHours;
    private Integer hoursForLectures;
    private Integer hoursForPractice;
    @Column(name = "lecturer_id")
    private Integer lecturerId;

    @ManyToOne()
    @JoinColumn(name = "lecturer_id", insertable = false, updatable = false)
    private User lecturer;
}
