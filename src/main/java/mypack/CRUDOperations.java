package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperations implements Operations
{
	static Connection con;
	
	static
	{
		try {
			con=DatabaseConnection.ConnectDB();
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		
		CRUDOperations obj = new CRUDOperations();
		
		System.out.println("\n Sign In \n");
		
		System.out.println("\nUserName : ");
		String u = sc.next();
		
		System.out.println("\nPassword: ");
		String p = sc.next();
		
		boolean valid = CheckUser.checkUserDB(u, p);
		
		if( valid )
		{
			
			System.out.println("Login successfully\n\n____________________________________________________");
			
			while(true)
			{
			int id;
			int choice;
			System.out.println("\t\tMain Menu\n");
			System.out.println("\n1: List Contact");
			System.out.println("\n2: Add Contact");
			System.out.println("\n3: Search Contact");
			System.out.println("\n4: Delete Contact");
			System.out.println("\n5: Update Contact");
			System.out.println("\n6: Exit");
			
			System.out.println("\nEnter your choice: ");			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
					obj.list();
					break;
			case 2: 
				
					System.out.println("\n Enter name : ");
					String nm = sc.next();
					
					System.out.println("\n Enter email : ");
					String email = sc.next();
					
					Contact ct = new Contact(nm,email);											
					obj.add(ct);
					break;
					
			case 3: 
				
					System.out.println("\n Enter Contact id : ");
					id = sc.nextInt();								
					obj.search(id);
					break;
			case 4:
					System.out.println("\n Enter Contact id : ");
					id = sc.nextInt();	
				 	obj.delete(id);
				 	break;
			case 5:
				
					System.out.println("\n Enter new email : ");
					String e = sc.next();
				
					System.out.println("\n Enter Contact id : ");
					id = sc.nextInt();	
				
					obj.update(id, e);
					break;
			case 6:
					System.out.println("Logout and Sign Off ! ");
					System.exit(0);
					
			}
			
		
			
			// 	while close	
			}
			
												
		}
		else
		{
			System.out.println("Not Valid User");
		
		}
	}
		
		
		


	@Override
	public void list() throws SQLException {
		// to fetch the records , we use Statement interface in java
				// to show the records in java , we use ResultSet interface
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from contact");
				
				while(rs.next())
				{
					System.out.println(rs.getInt("contactid")+"  "+rs.getString("name")+"  "+rs.getString("email"));
				}
		
	}

	
	@Override
	public void add(Contact u) throws SQLException 
	{
		// inserting a record 
		
		PreparedStatement ps = con.prepareStatement("insert into contact(name,email) values(?,?)");
		// ? is having index id starting from 1
		// ? is a placeholder -> a value mapped with set() functions
		
		ps.setString(1,u.getName() );
		ps.setString(2, u.getEmail());
		
		int i = ps.executeUpdate();
		System.out.println(i+" Record is inserted ! ");
							
	}

	@Override
	public void delete(int id) throws SQLException {

		PreparedStatement ps = con.prepareStatement("delete from contact where contactid = ?");
	
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		System.out.println(i+" Record is deleted ! ");
		
	}

	@Override
	public void search(int id) throws SQLException {
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from contact where contactid="+id);
		
		while(rs.next())
		{
			System.out.println(rs.getInt("contactid")+"  "+rs.getString("name")+"  "+rs.getString("email"));
		}
		
	}

	@Override
	public void update(int id, String e) throws SQLException 
	{
		
		PreparedStatement ps = con.prepareStatement("update contact set email = ? where contactid = ?");
	
		ps.setString(1, e);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		System.out.println(i+" Record is updated ! ");
		
				
	}
}