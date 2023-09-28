package empmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    
    public Connection c;
    public Statement s;
    public Conn(){
          
        try{
            String url = "jdbc:mysql://localhost:3306/ems";
            String username = "root";
            String password = "Attitude123@";
            
            c = DriverManager.getConnection(url, username,password);
            s = c.createStatement();
        }
        catch(SQLException e){
            e.printStackTrace();
        }       
    }
    
}
