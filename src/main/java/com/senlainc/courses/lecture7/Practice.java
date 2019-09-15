package com.senlainc.courses.lecture7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Practice implements Serializable {
    private String name;
    private transient int testCount;
    private int taskCount;
}
