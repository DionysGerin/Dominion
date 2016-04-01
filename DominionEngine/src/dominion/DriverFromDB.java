package dominion;
import java.sql.*;

public class DriverFromDB
{	
	public static void main(String[] args) throws SQLException 
	{
		Connection con;
		Statement statm;
		try 
		{
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdominion", "root" , "");
                    statm = con.createStatement();
                    ResultSet res = statm.executeQuery("select * from employees");
                    while (res.next()) System.out.println(res.getString("name ko1om") + ", " + res.getString("name kolom2"));
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