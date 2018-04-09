package util;


import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();

        configuration.
                addAnnotatedClass(BaseEntity.class)
        .addAnnotatedClass(Session.class)
        .addAnnotatedClass(Lecturer.class)
        .addAnnotatedClass(Exam.class)
        .addAnnotatedClass(Student.class)
        .addAnnotatedClass(Result.class)
        .configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}