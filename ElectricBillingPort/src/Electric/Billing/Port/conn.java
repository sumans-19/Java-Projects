package Electric.Billing.Port;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    conn() {
//    Class.forName("com.mysql.cj.jdbc.Driver");
//1st step : register the driver class 
// 2nd step : creating the connection from mysql
// 3rd step : creating the statement
// 4th step : executing mqsql queries
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "Suman@110473");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
