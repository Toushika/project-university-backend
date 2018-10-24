package com.enigma.dev.model.dto;

import java.io.Serializable;

public class AttendenceDto implements Serializable {
    private Integer rowId;
    private String studentId;
    private String studentAttendence;
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
        return "AttendenceDto{" +
                "rowId=" + rowId +
                ", studentId='" + studentId + '\'' +
                ", studentAttendence='" + studentAttendence + '\'' +
                ", attendenceDate='" + attendenceDate + '\'' +
                '}';
    }
}
