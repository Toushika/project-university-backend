package com.enigma.dev.model.dto;

import java.io.Serializable;

public class Request implements Serializable {
    private String studentId;

    @Override
    public String toString() {
        return "Request{" +
                "studentId='" + studentId + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
