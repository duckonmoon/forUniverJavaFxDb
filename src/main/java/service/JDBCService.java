package service;

import dao.JDBCDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCService {
    private JDBCDao jdbcDao = new JDBCDao();

    public JDBCService() {
    }

    public ResultSet select(String sql) throws SQLException {
        return jdbcDao.select(sql);
    }

    public void execSQL(String sql) throws SQLException {
        jdbcDao.execSQL(sql);
    }

    public void closeStatement() throws SQLException {
        jdbcDao.closeStatement();
    }
}
