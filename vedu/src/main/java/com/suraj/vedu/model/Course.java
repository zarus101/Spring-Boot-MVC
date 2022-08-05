package com.suraj.vedu.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    private String id;
    private String course_name;
    private String course_des;
    private String category;
    private Boolean is_course_available;

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_des() {
        return course_des;
    }

    public void setCourse_des(String course_des) {
        this.course_des = course_des;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIs_course_available() {
        return is_course_available;
    }

    public void setIs_course_available(Boolean is_course_available) {
        this.is_course_available = is_course_available;
    }
}
