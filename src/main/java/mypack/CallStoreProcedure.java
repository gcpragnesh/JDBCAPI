package mypack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;

public class CallStoreProcedure 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		
		Connection con = DatabaseConnection.ConnectDB();
		CallableStatement cs = con.prepareCall("{call 10353_pricebased(?)}");
		cs.setInt(1, 700);
		ResultSet rs =  cs.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getString("prnm")+"  "+rs.getInt("price"));
		}
		System.out.println("Store procedure called ! ");
		con.close();
	}
    
}

/*
 * create table products(id int primary key auto_increment, prnm varchar(100) , price int);
 * 
 * 
 * CREATE  PROCEDURE `10353_pricebased`(in var1 int)
begin
	
   select * from product where price > var1 order by id,prnm;
   	
end

*/
