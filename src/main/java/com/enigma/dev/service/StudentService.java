package com.enigma.dev.service;

import com.enigma.dev.dao.StudentDao;
import com.enigma.dev.model.dto.AttendenceDto;
import com.enigma.dev.model.dto.StudentDto;
import com.enigma.dev.model.dto.StudentSaveDto;
import com.enigma.dev.model.entity.StudentAttendence;
import com.enigma.dev.model.entity.StudentRecordEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<StudentDto> searchAllStudents() {
        logger.info("StudentService::searchAllStudents::");
        return studentDao.searchAllStudents();
    }

    @Override
    public StudentDto searchByStudentId(String studentId) {
        logger.info("StudentService::searchByStudentId::");
        return studentDao.searchByStudentId(studentId);
    }

    @Override
    public List<StudentAttendence> getAttendence() {
        logger.info("StudentService::getAttendence::");
        return studentDao.getAttendence();
    }

    @Override
    public boolean giveAttendence(AttendenceDto attendenceDto) {
        logger.info("StudentService::giveAttendence::");
        return studentDao.giveAttendence(attendenceDto);
    }

    @Override
    public boolean saveStudentInfo(StudentSaveDto studentSaveDto) {
        return studentDao.saveStudentInfo(studentSaveDto);
    }

}
