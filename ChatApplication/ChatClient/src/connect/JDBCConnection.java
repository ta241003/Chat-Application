package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {
    public static Connection getConnection(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ChatApplication;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String password = "Theanh241003";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, "sa", "Theanh241003");
        } catch (ClassNotFoundException ex) {
            System.out.println("Không load được driver");
        } catch (SQLException ex) {
            System.out.println("Không kết nối được");
        }
        return null;
    }
}