package com.student.management.sms.entity;

import javax.persistence.*;

@Entity
@Table(name = "classrooms")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class_name", nullable = false)
    private String className;
    @Column(name = "limit_student")
    private int limitStudent;
    @Column(name = "description")
    private String description;

    public ClassRoom()
    {

    }

    public ClassRoom(String className, int limitStudent, String description) {
        this.className = className;
        this.limitStudent = limitStudent;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLimitStudent() {
        return limitStudent;
    }

    public void setLimitStudent(int limitStudent) {
        this.limitStudent = limitStudent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
