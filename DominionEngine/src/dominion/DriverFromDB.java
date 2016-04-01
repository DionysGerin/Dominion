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
                    Class.forName(JDBC_DRIVER); //geeft een driver om te kunnen connecten, probleem want hij vind de juiste blijkbaar niet, dus we zullen met tomcat moeten werken wrs? 
                    // maar dat lukt niet zonder glassfish in netbeans, ik kan het gelik niet installere, dan maar terug naar eclipse? Zo'n werk!
                    
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