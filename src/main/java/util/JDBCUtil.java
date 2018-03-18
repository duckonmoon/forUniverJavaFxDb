package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newuniver";

    private static final String USER = "root";
    private static final String PASS = "1111";

    private JDBCUtil(){
    }

    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public static void shutDown() throws SQLException {
        conn.close();
    }
}
