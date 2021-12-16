package kata5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MailListReader {
        public static List<String> read(String fileName) throws FileNotFoundException, IOException{

        List<String> mailList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String mail;
            while((mail=reader.readLine()) != null){
                if(!mail.contains("@")){
                    continue;
                }
                mailList.add(new String(mail));
            }
        }
        return mailList;
    }
}

    
   
    

    
    

    
   
    

