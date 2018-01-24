package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RuiClear on 2018/1/15.
 */
public class Teacher {
    private Integer id;
    private String name;
   private String course;
private Set<Student> students = new HashSet<Student>();
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

    public String getCourse() {
        return course;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public Teacher() {
    }
}
