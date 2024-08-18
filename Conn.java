
package employ.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Sk@123456");
            s=c.createStatement();
            
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
    }
}
