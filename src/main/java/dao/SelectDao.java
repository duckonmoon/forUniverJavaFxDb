package dao;

import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class SelectDao {

    private static SelectDao INSTANCE;

    SessionFactory sessionFactory;

    private SelectDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static SelectDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SelectDao();
        }
        return INSTANCE;
    }

    private List<Object[]> executeSelect(String select) {
        return sessionFactory.getCurrentSession().createQuery(select).list();
    }
}