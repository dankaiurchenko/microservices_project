package com.danarossa.restapi.dto;

import com.danarossa.restapi.data.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithMark {
    private User student;
    private DtoMark dtoMark;
}
