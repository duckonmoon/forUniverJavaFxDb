package dao;

import util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDao {

    private Statement statement;

    public JDBCDao() throws SQLException {
    }

    public ResultSet select(String sql) throws SQLException {
        statement = JDBCUtil.getStatement();
        return statement.executeQuery(sql);
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void execSQL(String sql) throws SQLException {
        Statement statement = JDBCUtil.getStatement();
        statement.execute(sql);
        statement.close();
    }
}
