package com.enigma.dev.dao;

import com.enigma.dev.model.dto.AttendenceDto;
import com.enigma.dev.model.dto.StudentDto;
import com.enigma.dev.model.dto.StudentSaveDto;
import com.enigma.dev.model.entity.StudentAttendence;
import com.enigma.dev.model.entity.StudentDepartmentRecordEntity;
import com.enigma.dev.model.entity.StudentRecordEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional

public class StudentDao implements StudentDaoInterface {
    private static Logger logger = LoggerFactory.getLogger(StudentDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentDto> searchAllStudents() {

        List<StudentDto> studentDtoList = new ArrayList<>();

        logger.info("StudentDao::searchAllStudents");
        List<StudentRecordEntity> studentRecordEntityList = null;
        String qrystr = "SELECT * FROM `student_record`";

        try {
            Query query = this.entityManager.createNativeQuery(qrystr, StudentRecordEntity.class);

            studentRecordEntityList = (List<StudentRecordEntity>) query.getResultList();
            logger.info("StudentDao::searchAllStudents:: studentRecordEntityList " + studentRecordEntityList.toString());

            for (int i = 0; i < studentRecordEntityList.size(); i++) {
                StudentRecordEntity recordEntity = studentRecordEntityList.get(i);

                StudentDto studentDto = new StudentDto();
                studentDto.setSerialNo(recordEntity.getSerialNo());
                studentDto.setStudentId(recordEntity.getStudentId());
                studentDto.setCourse(recordEntity.getCourse());
                studentDto.setSection(recordEntity.getSection());
                studentDto.setSemester(recordEntity.getSemester());

                String qryString = "SELECT * FROM `student_department_record` r WHERE r.`student_id` =?1";
                Query query1 = this.entityManager.createNativeQuery(qryString, StudentDepartmentRecordEntity.class);
                query1.setParameter(1, recordEntity.getStudentId());

                List<String> deps = new ArrayList<>();
                List<StudentDepartmentRecordEntity> studentDepartmentRecordEntitieList = (List<StudentDepartmentRecordEntity>) query1.getResultList();
                for (int j = 0; j < studentDepartmentRecordEntitieList.size(); j++) {
                    logger.info("StudentDao::searchAllStudents:: studentDepartmentRecordEntitieList " + studentDepartmentRecordEntitieList.get(j).toString());

                    deps.add(studentDepartmentRecordEntitieList.get(j).getDepartment());
                }
                studentDto.setDepartment(deps);
                logger.info("StudentDao::searchAllStudents:: studentDto " + studentDto.toString());
                studentDtoList.add(studentDto);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return studentDtoList;
    }

    @Override
    public StudentDto searchByStudentId(String studentId) {

        logger.info("StudentDao::searchByStudentId:: studentRecordEntity: studentId" + studentId);
        StudentRecordEntity studentRecordEntity = null;
        StudentDto studentDto = new StudentDto();

        String qr2 = "SELECT * FROM `student_record` WHERE `student_id`=?1";
        try {
            Query query = this.entityManager.createNativeQuery(qr2, StudentRecordEntity.class);
            query.setParameter(1, studentId);
            studentRecordEntity = ((List<StudentRecordEntity>) query.getResultList()).get(0);

            logger.info("StudentDao::searchByStudentId:: studentRecordEntity " + studentRecordEntity.toString());


            studentDto.setSerialNo(studentRecordEntity.getSerialNo());
            studentDto.setStudentId(studentRecordEntity.getStudentId());
            studentDto.setCourse(studentRecordEntity.getCourse());
            studentDto.setSection(studentRecordEntity.getSection());
            studentDto.setSemester(studentRecordEntity.getSemester());

            String qr3 = "SELECT * FROM `student_department_record` WHERE `student_id`=?1";
            Query query1 = this.entityManager.createNativeQuery(qr3, StudentDepartmentRecordEntity.class);
            query1.setParameter(1, studentId);

            List<String> department = new ArrayList<>();

            List<StudentDepartmentRecordEntity> studentDepartmentRecordEntityList = query1.getResultList();

            for (int i = 0; i < studentDepartmentRecordEntityList.size(); i++) {
                department.add(studentDepartmentRecordEntityList.get(i).getDepartment());
            }

            studentDto.setDepartment(department);


        } catch (Exception e) {
            e.printStackTrace();

        }

        logger.info("StudentDao::searchByStudentId:: studentDto " + studentDto.toString());
        return studentDto;
    }

    @Override
    public List<StudentAttendence> getAttendence() {
        logger.info("StudentDao::getAttendence");
        List<StudentAttendence> attendenceList = null;
        String qrystr = "SELECT * FROM `student_attendence";
        try {
            Query query = this.entityManager.createNativeQuery(qrystr, StudentAttendence.class);
            attendenceList = (List<StudentAttendence>) query.getResultList();
            logger.info("StudentDao::getAttendence" + attendenceList.toString());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return attendenceList;
    }

    @Override
    public boolean giveAttendence(AttendenceDto attendenceDto) {

        boolean isSaved = false;
        logger.info("StudentDao:: giveAttendence:: " + attendenceDto.toString());
        String qrystr = "SELECT * FROM `student_attendence` WHERE `student_id` =?1  AND `attendence_date`=?2";

        StudentAttendence studentAttendence = null;

        Query query = this.entityManager.createNativeQuery(qrystr, StudentAttendence.class);
        query.setParameter(1, attendenceDto.getStudentId());
        query.setParameter(2, getPresentDate());
        List<StudentAttendence> studentAttendenceList = (List<StudentAttendence>) query.getResultList();


        if (studentAttendenceList.size() != 0) {
            studentAttendence = studentAttendenceList.get(0);
            logger.info("StudentDao:: giveAttendence:: studentAttendence: " + studentAttendence.toString());
            studentAttendence.setStudentAttendence(attendenceDto.getStudentAttendence());
            isSaved = true;
        } else {

            studentAttendence = new StudentAttendence();
            studentAttendence.setStudentAttendence(attendenceDto.getStudentAttendence());
            studentAttendence.setStudentId(attendenceDto.getStudentId());
            studentAttendence.setAttendenceDate(getPresentDate());
            logger.info("StudentDao:: giveAttendence:: studentAttendence: " + studentAttendence.toString());
            this.entityManager.persist(studentAttendence);
            isSaved = true;
        }

        return isSaved;

    }

    @Override
    public boolean saveStudentInfo(StudentSaveDto studentSaveDto) {
        boolean isSaved = false;
        try {
            StudentRecordEntity studentRecordEntity = new StudentRecordEntity();
            StudentDepartmentRecordEntity studentDepartmentRecordEntity1 = new StudentDepartmentRecordEntity();
            StudentDepartmentRecordEntity studentDepartmentRecordEntity2 = new StudentDepartmentRecordEntity();
            StudentDepartmentRecordEntity studentDepartmentRecordEntity3 = new StudentDepartmentRecordEntity();

            String studentId = null;

            if (studentSaveDto.getStudentId() != null) {
                studentId = studentSaveDto.getStudentId();
                studentRecordEntity.setStudentId(studentSaveDto.getStudentId());
            }
            if (studentSaveDto.getCourse() != null) {
                studentRecordEntity.setCourse(studentSaveDto.getCourse());
            }
            if (studentSaveDto.getSection() != null) {
                studentRecordEntity.setSection(studentSaveDto.getSection());
            }
            if (studentSaveDto.getSemester() != null) {
                studentRecordEntity.setSemester(studentSaveDto.getSemester());
            }

            this.entityManager.persist(studentRecordEntity);

            if (studentSaveDto.getCseDepartment() != null) {
                studentDepartmentRecordEntity1.setStudentId(studentId);
                studentDepartmentRecordEntity1.setDepartment("CSE");
                this.entityManager.persist(studentDepartmentRecordEntity1);


            }

            if (studentSaveDto.getEeeDepartment() != null) {
                studentDepartmentRecordEntity2.setStudentId(studentId);
                studentDepartmentRecordEntity2.setDepartment("EEE");
                this.entityManager.persist(studentDepartmentRecordEntity2);

            }

            if (studentSaveDto.getEteDepartment() != null) {
                studentDepartmentRecordEntity3.setStudentId(studentId);
                studentDepartmentRecordEntity3.setDepartment("ETE");
                this.entityManager.persist(studentDepartmentRecordEntity3);

            }


            isSaved = true;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSaved;
    }

    private String getPresentDate() {
        String presentDate = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();
        presentDate = simpleDateFormat.format(date);
        return presentDate;
    }
}
