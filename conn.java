package airlinemanagementsystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "1@Acivilias");
            s = c.createStatement();  // Correct reference
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
