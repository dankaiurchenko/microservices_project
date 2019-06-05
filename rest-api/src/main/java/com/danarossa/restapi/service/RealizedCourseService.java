package com.danarossa.restapi.service;

import com.danarossa.restapi.data.RealizedCourse;
import com.danarossa.restapi.dto.StudentWithMark;

import java.util.List;

public interface RealizedCourseService {
    Iterable<RealizedCourse> all();

    RealizedCourse byId(Integer realizedCourseId);

    RealizedCourse createNew(RealizedCourse realizedCourse);

    RealizedCourse edit(RealizedCourse realizedCourse);

    void delete(Integer realizedCourseId);

    List<StudentWithMark> allOfCourse(Integer realizedCourseId);
}
