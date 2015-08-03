package pawc.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Persistence {

    public static List<EntryModel> getAllEntries(){
        
        List<EntryModel> list = new ArrayList<EntryModel>();
        
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Could't find sql driver");
            return null;
        }
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://pawc.ddns.net:5432/postgres", "xml", "xml");
            Statement stmt = conn.createStatement();
            String query = "Select * from entries;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EntryModel entry = new EntryModel(rs.getString(1), rs.getString(2));
                list.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
              
        return list;
    }
    
    public static void newEntry(String author, String message){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Could't find sql driver");
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://pawc.ddns.net:5432/postgres", "xml", "xml");
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO entries VALUES ('"+author+"', '"+message+"');";
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
}
