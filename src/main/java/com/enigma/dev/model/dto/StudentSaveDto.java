package com.enigma.dev.model.dto;

public class StudentSaveDto {
    private String studentId;
    private String course;
    private String section;
    private String semester;
    private String cseDepartment;
    private String eeeDepartment;
    private String eteDepartment;

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

    public String getCseDepartment() {
        return cseDepartment;
    }

    public void setCseDepartment(String cseDepartment) {
        this.cseDepartment = cseDepartment;
    }

    public String getEeeDepartment() {
        return eeeDepartment;
    }

    public void setEeeDepartment(String eeeDepartment) {
        this.eeeDepartment = eeeDepartment;
    }

    public String getEteDepartment() {
        return eteDepartment;
    }

    public void setEteDepartment(String eteDepartment) {
        this.eteDepartment = eteDepartment;
    }

    @Override
    public String toString() {
        return "StudentSaveDto{" +
                "studentId='" + studentId + '\'' +
                ", course='" + course + '\'' +
                ", section='" + section + '\'' +
                ", semester='" + semester + '\'' +
                ", cseDepartment='" + cseDepartment + '\'' +
                ", eeeDepartment='" + eeeDepartment + '\'' +
                ", eteDepartment='" + eteDepartment + '\'' +
                '}';
    }
}
