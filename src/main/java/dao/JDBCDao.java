package dao;

import util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDao {

    private Statement statement = JDBCUtil.getStatement();

    public JDBCDao() throws SQLException {
    }


    public ResultSet getAllEntities() throws SQLException {
        Statement statement = JDBCUtil.getStatement();
        String query = "Select * from classintable";
        return statement.executeQuery(query);
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }
}
