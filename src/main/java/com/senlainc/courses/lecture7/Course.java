package com.senlainc.courses.lecture7;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Course implements Serializable {
    private List<Practice> practices;
    private List<Lecture> lectures;
}
