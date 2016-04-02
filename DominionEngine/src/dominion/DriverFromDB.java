package dominion;
import java.sql.*;

public class DriverFromDB
{	
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/dbdominion";
   
   static final String USER = "root";
   static final String PASS = "";
   
	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		Statement statm = null;
		try 
		{
                    Class.forName("com.mysql.jdbc.Driver"); //Ik heb de jar file toegevoegd aan de build path/library van het project, zodat hij de MySQLconnector.jar gebruikt om de lokale
                    // netbeans services te kunnen gebruiken, aka de inbuild database! We moeten dus niet naar eclipse weer overschakelen!
                    
                    con = DriverManager.getConnection(DB_URL, USER, PASS);
                    statm = con.createStatement();
                    ResultSet res = statm.executeQuery("select * from cards");
                    while (res.next()) System.out.println("Card Name: " + res.getString("cardname") + ", " + res.getInt("cost") + ", " + res.getString("cardtype"));
                    
                    res.close();
                    statm.close();
                    con.close();
		} catch (Exception e) 
                {
                    e.printStackTrace();
                } finally  // wordt uigevoerd enkel als de try block true is volgenden code sluit alle variabelen af
                { 
                    if (statm != null) statm.close();
                    if (con != null) con.close(); //close verwijderd het scanner object
		}
	}
}