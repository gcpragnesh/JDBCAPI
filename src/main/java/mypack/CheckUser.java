package mypack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUser 
{
	static Connection con;
	
	static
	{
		try {
			con = DatabaseConnection.ConnectDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public static boolean checkUserDB(String unm,String pwd) throws SQLException
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from users where username='"+unm+"' and password='"+pwd+"'");
		while(rs.next())
		{
			con.close();
			return true;
		}
		
	con.close();	
	return false;
	}
	
}
