package com.enigma.dev.service;

import com.enigma.dev.model.dto.AttendenceDto;
import com.enigma.dev.model.dto.StudentDto;
import com.enigma.dev.model.dto.StudentSaveDto;
import com.enigma.dev.model.entity.StudentAttendence;
import com.enigma.dev.model.entity.StudentRecordEntity;

import java.util.List;

public interface StudentServiceInterface {
    public List<StudentDto> searchAllStudents();

    public StudentDto searchByStudentId(String studentId);

    public List<StudentAttendence> getAttendence();

    public boolean giveAttendence(AttendenceDto attendenceDto);

    public boolean saveStudentInfo(StudentSaveDto studentSaveDto);
}
