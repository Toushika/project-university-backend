package com.enigma.dev.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="student_record")
public class StudentRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serial_no")
    private Integer serialNo;

    @Column(name = "student_id")
    @Size(max = 255)
    private String studentId;

    @Column(name = "course")
    @Size(max = 255)
    private String course;

    @Column(name = "section")
    @Size(max = 255)
    private String section;

    @Column(name = "semester")
    @Size(max = 255)
    private String semester;

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


    @Override
    public String toString() {
        return "StudentRecordEntity{" +
                "serialNo=" + serialNo +
                ", studentId='" + studentId + '\'' +
                ", course='" + course + '\'' +
                ", section='" + section + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
