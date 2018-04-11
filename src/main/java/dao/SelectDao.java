package dao;

import entity.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static controller.DeleteController.*;

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

    public void delete(BaseEntity object, String clazz) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try{
            manager.getTransaction().begin();

            Object persistanceObject;
            switch (clazz) {
                case SESSION:
                    persistanceObject = manager.find(Session.class, object.getId());
                    break;
                case LECTURER:
                    persistanceObject = manager.find(Lecturer.class, object.getId());
                    break;
                case STUDENT:
                    persistanceObject = manager.find(Student.class, object.getId());
                    break;
                case EXAM:
                    persistanceObject = manager.find(Exam.class, object.getId());
                    break;
                case RESULT:
                    persistanceObject = manager.find(Result.class, object.getId());
                    break;
                default:
                    persistanceObject = null;
                    break;
            }
            manager.remove(persistanceObject);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            manager.close();
            throw e;
        }
    }

    public void insert(BaseEntity object){
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
            manager.close();
        }
    }
}