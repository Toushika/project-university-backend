package com.enigma.dev.controller;

import com.enigma.dev.model.dto.AttendenceDto;
import com.enigma.dev.model.dto.Request;
import com.enigma.dev.model.dto.StudentDto;
import com.enigma.dev.model.dto.StudentSaveDto;
import com.enigma.dev.model.entity.StudentAttendence;
import com.enigma.dev.model.entity.StudentRecordEntity;
import com.enigma.dev.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentRecordController {
    private static Logger logger = LoggerFactory.getLogger(StudentRecordController.class);
    @Autowired
    private StudentService studentService;

    @CrossOrigin(value = "*")
    @PostMapping("/searchAllStudents")
    public ResponseEntity<?> searchAllStudents() {
        logger.info("StudentRecordController:: searchAllStudents");
        List<StudentDto> studentDtoList = studentService.searchAllStudents();
        logger.info("StudentRecordController:: searchAllStudents :: studentDtoList: " + studentDtoList.toString());

        return new ResponseEntity(studentDtoList, HttpStatus.OK);
    }


    @CrossOrigin(value = "*")
    @PostMapping("/searchByStudentId")
    public ResponseEntity<?> searchByStudentId(@RequestBody Request request) {
        logger.info("StudentRecordController::searchByStudentId " + request.getStudentId());
        StudentDto studentDto = studentService.searchByStudentId(request.getStudentId());
        logger.info("StudentRecordController::searchByStudentId" + studentDto.toString());
        return new ResponseEntity(studentDto, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @PostMapping("/getAttendence")
    public ResponseEntity<?> getAttendence() {
        logger.info("StudentRecordController:: getAttendence");
        List<StudentAttendence> attendenceList = studentService.getAttendence();
        logger.info("StudentRecordController:: getAttendence :: studentDtoList: " + attendenceList.toString());
        return new ResponseEntity(attendenceList, HttpStatus.OK);
    }

    @PostMapping("/giveAttendence")
    public ResponseEntity<?> giveAttendence(@RequestBody AttendenceDto attendenceDto) {
        logger.info("StudentRecordController :: giveAttendence :: " + attendenceDto.toString());
        studentService.giveAttendence(attendenceDto);
        logger.info("StudentRecordController :: giveAttendence :: " + attendenceDto.toString());

        return new ResponseEntity("", HttpStatus.OK);
    }

    @PostMapping("/saveStudentInfo")
    public ResponseEntity<?> saveStudentInfo(@RequestBody StudentSaveDto studentSaveDto) {
        logger.info("StudentRecordController :: saveStudentInfo :: " + studentSaveDto.toString());
        boolean result = studentService.saveStudentInfo(studentSaveDto);
        logger.info("StudentRecordController :: saveStudentInfo :: " + studentSaveDto.toString());

        return new ResponseEntity(result, HttpStatus.OK);
    }

}
