package dominion;
import java.sql.*;
import java.util.*;

public class SupplyCardCreatorFromDB
{	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbdominion";
   
    static final String USER = "root";
    static final String PASS = "";
        
    public ArrayList<TreasureCard> returnTreasureCardSupply(String treasureCardName, int amount) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de supplycard
        int cost = 0;
        int value = 0;
        ArrayList<TreasureCard> supplyCard = new ArrayList(10);

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();
            
            String sql = "select * from cards where cardname = '" + treasureCardName + "'";
            ResultSet res = statm.executeQuery(sql); // geloof het of niet, maar er zat een enter in de databse voor gold, nice
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            if (res.next()) cost = res.getInt("cost"); //Je moet res.next()callen en checken of die true is om de eerste lijn te van de resultaatset vast te krijgen 

            sql = "select * from treasurecard where cardnumber = (select cardnumber from cards where cardname = '" + treasureCardName + "')";
            res = statm.executeQuery(sql);
            //PART TWO, de value van de treasurecard ophalen
            if (res.next()) value = res.getInt("value");

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        for (int i = 0; i < amount; i++) supplyCard.add(new TreasureCard(treasureCardName, cost, value));
        
        return supplyCard;
    }
    
    public ArrayList<VictoryCard> returnVictoryCardSupply(String victoryCardName, int amount) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de kaart
        int cost = 0;
        int value = 0;
        ArrayList<VictoryCard> supplyCard = new ArrayList(10);

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();
            
            String sql = "select * from cards where cardname = '" + victoryCardName + "'";
            ResultSet res = statm.executeQuery(sql);
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            if (res.next()) cost = res.getInt("cost");

            sql = "select * from victorycard where cardnumber = (select cardnumber from cards where cardname = '" + victoryCardName + "')";
            res = statm.executeQuery(sql);
            //PART TWO, de value van de victorycard ophalen
            if (res.next()) value = res.getInt("value");

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        for (int i = 0; i < amount; i++) supplyCard.add(new VictoryCard(victoryCardName, cost, value));
        
        return supplyCard;
    }
    
    public ArrayList<KingdomCard> returnKingdomCardSupply(String kingdomCardName, int amount) throws SQLException 
    {
        //Variabelen voor de connectie
        Connection con = null;
        Statement statm = null;

        //Variabelen voor de creatie van de kaart
        int cost = 0;
        int value = 0;
        ArrayList<KingdomCard> supplyCard = new ArrayList(10);

        try 
        {
            //De driver connector gebruiken om een connectie te maken
            Class.forName(JDBC_DRIVER);

            //Connectie opstellen en een resultaatset ophalen van de gegevens dat we nodig hebben
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statm = con.createStatement();

            String sql = "select * from cards where cardname = '" + kingdomCardName + "'";
            ResultSet res = statm.executeQuery(sql);
            //De resultaatset verdelen in variabelen zodat we ze apart kunnen gebruiken

            //PART ONE, de cost ophalen uit de tabel cards                    
            if (res.next()) cost = res.getInt("cost");

            //PART TWO, hier zouden de acties moeten zitten, die zijn nog niet geimplementeerd!!

            //Alles sluiten van de connectie dat we niet meer nodig hebben of zullen gebruiken, wordt opnieuw geinitialiseerd als we meer gegevens nodig hebben
            res.close();
            statm.close();
            con.close();

        } catch (Exception e) //Nodig voor de klasse die we zoeken, als deze niet gevonden is dan wordt deze catch uitgevoerd, zonder krijgen we errors in onze code
        {
            e.printStackTrace();
        }

        for (int i = 0; i < amount; i++) supplyCard.add(new KingdomCard(kingdomCardName, cost));

        return supplyCard;
    }
}