package service;

import dao.SelectDao;
import dto.ExamDTO;
import dto.ResultDTO;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class SelectService {
    private SelectDao selectDao = new SelectDao();

    public SelectService() {
    }

    public List<Session> getAllSessions() {
        return selectDao.getAllSessions();
    }

    public List<Lecturer> getAllLecturers() {
        return selectDao.getAllLecturers();
    }

    public List<Student> getAllStudents() {
        return selectDao.getAllStudents();
    }

    public List<Result> getAllClearResults() {
        return selectDao.getAllResults();
    }

    public List<Exam> getAllClearExams() {
        return selectDao.getAllExams();
    }

    public List<ResultDTO> getAllResults() {
        List<Result> results = selectDao.getAllResults();
        List<ResultDTO> resultDTOS = new ArrayList<>();
        for (Result result : results) {
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setId(result.getId());
            resultDTO.setCommision1(result.getCommision1());
            resultDTO.setCommision2(result.getCommision2());
            resultDTO.setExam(result.getExam().getSubject());
            resultDTO.setMark(result.getMark());
            resultDTO.setStudent(result.getStudent().getIdentical_number());
            resultDTOS.add(resultDTO);
        }
        return resultDTOS;
    }

    public List<ExamDTO> getAllExams() {
        List<Exam> exams = selectDao.getAllExams();
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (Exam exam : exams) {
            ExamDTO examDTO = new ExamDTO();
            examDTO.setId(exam.getId());
            examDTO.setDate(exam.getDate());
            examDTO.setSubject(exam.getSubject());
            examDTO.setLecturer(exam.getLecturer().getName() + " " + exam.getLecturer().getSurname());
            examDTO.setStartSession(exam.getSession().getStartDate());
            examDTO.setEndSession(exam.getSession().getEndDate());
            examDTOS.add(examDTO);
        }
        return examDTOS;
    }

    public void delete(BaseEntity object, String clazz) {
        selectDao.delete(object, clazz);
    }

    public void insert(BaseEntity entity) {
        selectDao.insert(entity);
    }

    public void update(BaseEntity entity) {
        selectDao.update(entity);
    }
}
