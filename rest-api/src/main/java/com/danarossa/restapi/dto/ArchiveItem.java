package com.danarossa.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveItem {
    private Integer markId;
    private String  courseName;
    private Integer realizedCourseId;
    private String trainerName;
    private Date endDate;
    private Integer mark;
}
