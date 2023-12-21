import java.sql.*;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Manager_Password16:)";

    public static Statement connection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}