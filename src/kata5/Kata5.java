package kata5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kata5{
   String email = "C:\\email\\email.txt";
   
    
    public static void main(String[] args) {
        
        Kata5 idt= new Kata5();
     // Se insertar 3 nuevas líneas
    idt.insert("stsphsn.mrrqurrd@uct.rc.fr");
    idt.insert("KdwsjbJKJIHH");
    idt.insert("ljuis@msdir.bsrkslsy.sdu");
          connect();
        createNewTable();
        selectAll("EMAIL");
    }
    
    public static Connection connect(){
        String url = "jdbc:sqlite:C:\\sql\\kata5p1_v2.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException ex) {
            Logger.getLogger(Kata5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    private static void selectAll(String from){
        String sql = "SELECT * FROM " + from;
        
        try (   Connection conn = connect();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql)){
            System.out.println("");
            
            while (rs.next()){
                System.out.println(rs.getInt("Id") + "\t" + 
                        rs.getString("Mail") + "\t");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("");
    }
    
    public static void createNewTable(){
        String url = "jdbc:sqlite:C:\\sql\\kata5p1_v2.db";
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " Id integer PRIMARY KEY AUTOINCREMENT, \n"
                + " Mail text NOT NULL);";
        
        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(String email){
        String url = "jdbc:sqlite:C:\\sql\\kata5p1_v2.db";
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("Correo insertado " + email);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}  


    
    
    

            


    

    



    

   
    
   

   
    
 