package dominion;
import java.sql.*;

public class DriverToDB
{
	public static void main(String[] args) throws SQLException
	{
		String url = "jdbc:mysql://localhost:8080/Dominion";
		String user = "username";
		String password ="password";
		Connection con = null;
		Statement statm = null;
		try
		{
			con = DriverManager.getConnection(url, user , password);
			statm = con.createStatement();
			String sql = "this is the sql insert statement"
					   + "seperate the lines with a concatination sign (+)";
			statm.executeUpdate(Dominion);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
                    if (statm != null) statm.close();
                    if (con != null) con.close();
		}
	}
}
