import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBManager.connection();
        createTable( "first_name", "last_name");
//        populateTable("giorgia", "espa");
//        populateTable("pieTro", "di giovanni");
//        populateTable("paola", "ammaturo");
//        populateTable("simone", "farina");
    }

    public static void createTable (String first_name, String last_name) {
        try {
            String q = "CREATE TABLE IF NOT EXISTS students (student_id INT PRIMARY KEY AUTO_INCREMENT, " + first_name + " VARCHAR(30) NOT NULL, " + last_name + " VARCHAR (30) NOT NULL);";
            DBManager.connection().execute(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void populateTable(String first_name, String last_name){
        try {
            String q = "INSERT INTO students (first_name, last_name) VALUES ('" + first_name + "','" + last_name + "');";
            DBManager.connection().executeUpdate(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
