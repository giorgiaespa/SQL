import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBManager.connection();
        //addColumn();
        //citizenship();
        //citizenship2();
    }

    public static void addColumn() {
        try {
            String q = "ALTER TABLE students ADD COLUMN country VARCHAR(30) NOT NULL;";
            DBManager.connection().executeUpdate(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void citizenship (){
        try{
            String q = "UPDATE students SET country = 'Italy' LIMIT 2;";
            DBManager.connection().executeUpdate(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void citizenship2 (){
        try{
            String q = "UPDATE students SET country = 'Germany' WHERE student_id = 3 AND student_id = 4;";
            DBManager.connection().executeUpdate(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}