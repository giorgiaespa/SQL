import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBManager.connection();
        takeEverything();
    }

    public static void takeEverything() {
        try {
            String q = "SELECT first_name, last_name FROM students;";
            ResultSet resultSet = DBManager.connection().executeQuery(q);
            ArrayList<String> surnames = new ArrayList<>();
           while (resultSet.next()) {
               System.out.println(resultSet.getString("first_name") + " ");
                String surname = resultSet.getString("last_name");
                surnames.add(surname);
            }
           for (String surname : surnames) {
               System.out.println(surname);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}