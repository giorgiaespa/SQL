import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBManager.connection();
        //viewItalian();
        //viewGerman();
        System.out.println("italian students " + selectItalian());
        System.out.println("german students " + selectGerman());
    }

    public static void viewItalian() {
        try {
            String q = "CREATE VIEW italian_students AS SELECT first_name, last_name FROM students WHERE country LIKE 'Italy';";
            DBManager.connection().execute(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewGerman() {
        try {
            String q = "CREATE VIEW german_students AS SELECT first_name, last_name FROM students WHERE country LIKE 'Germany';";
            DBManager.connection().execute(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> selectItalian() {
        ArrayList<String> italianStudents = new ArrayList<>();
        try {
            String q = "SELECT * FROM italian_students;";

            ResultSet rs = DBManager.connection().executeQuery(q);
            while (rs.next()) {
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                italianStudents.add(name);
                italianStudents.add(surname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return italianStudents;
    }

    public static ArrayList<String> selectGerman() {
        ArrayList<String> germanStudents = new ArrayList<>();
        try {
            String q = "SELECT * FROM german_students;";

            ResultSet rs = DBManager.connection().executeQuery(q);
            while (rs.next()) {
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                germanStudents.add(name);
                germanStudents.add(surname);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return germanStudents;
    }
}
