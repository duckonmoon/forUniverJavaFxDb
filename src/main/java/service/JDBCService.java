package service;

import dao.JDBCDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCService {
    private JDBCDao jdbcDao = new JDBCDao();

    public JDBCService() throws SQLException {
    }

    public ResultSet getAllEntities() throws SQLException {
        return jdbcDao.getAllEntities();
    }

    public void closeStatement() throws SQLException {
        jdbcDao.closeStatement();
    }
}
