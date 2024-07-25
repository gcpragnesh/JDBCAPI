package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	public static Connection ConnectDB() throws ClassNotFoundException, SQLException
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "angad#18");
      
      if(cn!=null)
    	  return cn;
     
      return null;          	   
    }

}
