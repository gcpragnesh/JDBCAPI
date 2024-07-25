package mypack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class OutParameter {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch9630", "root", "angad#18");
	      
	  	CallableStatement cs = cn.prepareCall("{call strproc_cardtype(?,?)}");
		cs.setInt(1, 4);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.executeQuery();
		System.out.println("Card Type : "+ cs.getString(2));
		
	      	
	}

}
