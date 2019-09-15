package com.senlainc.courses.lecture7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "student")
@XmlRootElement
public class Student {
    private String name;
    private int age;
}
