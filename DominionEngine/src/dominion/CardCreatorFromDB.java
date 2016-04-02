package dominion;
import java.sql.*;

public class CardCreatorFromDB
{	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbdominion";
   
    static final String USER = "root";
    static final String PASS = "";
   
    public TreasureCard returnTreasureCard(String treasureCardName) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de kaart
        int cost = 0;
        int value = 0;

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();

            ResultSet res = statm.executeQuery("select * from cards where cardname = '" + treasureCardName + "'"); // geloof het of niet, maar er zat een enter in de databse voor gold, nice
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            cost = res.getInt("cost");

            res = statm.executeQuery("select * from treasurecard where cardnumber = (select cardnumber from cards where cardname = ')" + treasureCardName + "'");
            //PART TWO, de value van de treasurecard ophalen
            value = res.getInt("value");

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        //Hier zullen we het kaart object maken met de opgevangen gegevens en returnen naar het object die het nodig heeft
        return new TreasureCard(treasureCardName, cost, value);
    }
    
    public VictoryCard returnVictoryCard(String victoryCardName) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de kaart
        int cost = 0;
        int value = 0;

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();

            ResultSet res = statm.executeQuery("select * from cards where cardname = '" + victoryCardName + "'");
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            cost = res.getInt("cost");

            res = statm.executeQuery("select * from treasurecard where cardnumber = (select cardnumber from cards where cardname = '" + victoryCardName + "')");
            //PART TWO, de value van de victorycard ophalen
            value = res.getInt("value");

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        //Hier zullen we het kaart object maken met de opgevangen gegevens en returnen naar het object die het nodig heeft
        return new VictoryCard(victoryCardName, cost, value);
    }
    
    public KingdomCard returnKingdomCard(String kingdomCardName) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de kaart
        int cost = 0;
        int value = 0;

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();

            ResultSet res = statm.executeQuery("select * from cards where cardname = '" + kingdomCardName + "'");
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            cost = res.getInt("cost");

            //PART TWO, hier zouden de acties moeten zitten, die zijn nog niet geimplementeerd!!

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        //Hier zullen we het kaart object maken met de opgevangen gegevens en returnen naar het object die het nodig heeft
        return new KingdomCard(kingdomCardName, cost);
    }
}