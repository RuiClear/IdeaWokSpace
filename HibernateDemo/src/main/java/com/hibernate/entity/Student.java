package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RuiClear on 2018/1/2.
 */
public class Student {
    private Integer id;
    private String name;
    private String school;
    private Set<Teacher> teachers=new HashSet<Teacher>();
    public Student() {
    }

    public Student( String name, String school) {
        this.name = name;
        this.school = school;
    }


    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
