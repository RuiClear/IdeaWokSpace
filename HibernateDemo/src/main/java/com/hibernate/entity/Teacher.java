package com.hibernate.entity;

/**
 * Created by RuiClear on 2018/1/15.
 */
public class Teacher {
    private Integer id;
    private String name;
   private String course;

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
