package com.enigma.dev.model.dto;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable {
    private Integer serialNo;
    private String studentId;
    private String course;
    private String section;
    private String semester;
    private List<String> department;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "serialNo=" + serialNo +
                ", studentId='" + studentId + '\'' +
                ", course='" + course + '\'' +
                ", section='" + section + '\'' +
                ", semester='" + semester + '\'' +
                ", department=" + department +
                '}';
    }
}
