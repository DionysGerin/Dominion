package dominion;
import java.sql.*;

public class DriverToDB
{
	public static void main(String[] args) thows SQLException
	{
		String url = "jdbc:mysql://localhost:8080/Dominion";
		String user = "username":
		String password ="password";
		Connection con;
		Statement statm;
		try
		{
			Connection con = DriverManager.getconnnection(url, user , password)
			Statement Statm = con.createStatement();
			String sql = "this is the sql insert statement"
					   + "seperate the lines with a concatination sign (+)";
			statm.executeUpdate(Dominion)
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
		if (statm != null) statm.close();
		if (con != null) myConn.close();
		}
	}
}
