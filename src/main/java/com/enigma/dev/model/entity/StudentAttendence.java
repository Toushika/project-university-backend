package com.enigma.dev.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
@Table(name="student_attendence")
public class StudentAttendence implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "row_id")
    private Integer rowId;

    @Column(name = "student_id")
    @Size(max = 255)
    private String studentId;

    @Column(name = "student_attendence")
    @Size(max = 255)
    private String studentAttendence;

    @Column(name = "attendence_date")
    @Size(max = 255)
    private String attendenceDate;

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentAttendence() {
        return studentAttendence;
    }

    public void setStudentAttendence(String studentAttendence) {
        this.studentAttendence = studentAttendence;
    }

    public String getAttendenceDate() {
        return attendenceDate;
    }

    public void setAttendenceDate(String attendenceDate) {
        this.attendenceDate = attendenceDate;
    }


    @Override
    public String toString() {
        return "StudentAttendence{" +
                "rowId=" + rowId +
                ", studentId='" + studentId + '\'' +
                ", studentAttendence='" + studentAttendence + '\'' +
                ", attendenceDate='" + attendenceDate + '\'' +
                '}';
    }
}
