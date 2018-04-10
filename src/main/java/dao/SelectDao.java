package dao;

import entity.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SelectDao {

    private EntityManagerFactory entityManagerFactory;

    public SelectDao() {
        entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    public List<Session> getAllSessions() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        List<Session> sessions = manager.createQuery("from Session").getResultList();
        manager.close();
        return sessions;
    }

    public List<Lecturer> getAllLecturers() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        List<Lecturer> lecturers = manager.createQuery("from Lecturer").getResultList();
        manager.close();
        return lecturers;
    }

    public List<Student> getAllStudents() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        List<Student> students = manager.createQuery("from Student ").getResultList();
        manager.close();
        return students;
    }

    public List<Result> getAllResults() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        List<Result> results = manager.createQuery("from Result").getResultList();
        manager.close();
        return results;
    }

    public List<Exam> getAllExams() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        List<Exam> exams = manager.createQuery("from Exam ").getResultList();
        manager.close();
        return exams;
    }
}