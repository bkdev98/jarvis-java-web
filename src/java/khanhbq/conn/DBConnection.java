package khanhbq.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JARVIS_DB";
        Connection conn = DriverManager.getConnection(url, "sa", "1Cong1>2");
        return conn;
    }
}
