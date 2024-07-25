package mypack;

import java.sql.SQLException;

public interface Operations 
{
	void list()throws SQLException ;
	void add(Contact u) throws SQLException ;
	void delete(int id) throws SQLException ;
	void search(int id) throws SQLException ;
	void update(int id,String e) throws SQLException ;
		
}
