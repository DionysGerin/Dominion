package jdbcdriver;
import java.sql.*;

public class Driverfromdb
{	
	public static void main(String[] args) throws SQLException 
	{
		Connection con;
		Statement statm;
		ResultSet res;
		try 
		{
		con = DriverManager.getConnection("jdbc:mysql://localhost:8080/Dominion", "username" , "password");
		statm = con.createStatement();
		res = statm.executeQuery("select * from employees");
		while (res.next()) System.out.println(res.getString("name tabel1") + ", " + res.getString("name table 2"));
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		finally  // wordt uigevoerd enkel als de try block true is volgenden code sluit alle variabelen af
		{ 
		if (res != null) res.close();
		if (statm != null) statm.close();
		if (con != null) con.close(); //close verwijderd het scanner object
		}
	}
}