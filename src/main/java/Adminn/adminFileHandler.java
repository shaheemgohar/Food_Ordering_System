package Adminn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Shaheem
 */

public class adminFileHandler {
    
    public static void writeToFile(ArrayList<adminUserRegistrationClass> users, String filename){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(filename, true));){            //// No need to manually close 'writer'—it's automatically closed when the try block exits
            
            for(adminUserRegistrationClass user: users){
                br.write(user.toString());
                br.newLine();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    //to write single user
    public static void writeToFile(adminUserRegistrationClass user, String filepath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
        writer.write(user.toString());
        writer.newLine();  // Add a newline after each user entry
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
    
    public static ArrayList<adminUserRegistrationClass> readFromFile(String filename){
        ArrayList<adminUserRegistrationClass> users = new ArrayList<>(); //going to contain all the users
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Split each line into user attributes
                String[] userData = line.split(";");
                
                    String userID = userData[0];
                    String username = userData[1];
                    String password = userData[2];
                    String name = userData[3];
                    String phone = userData[4];
                    String rolecb = userData[5];
                    String balance = userData[6];
                    
                // Create a new user object with the data
                    adminUserRegistrationSubClass user = new adminUserRegistrationSubClass(userID, username, password, name, phone, rolecb, balance);
                    users.add(user);  // Add the user to the list
            }
            
        }catch(IOException e){
            System.out.println("An error occurred while reading from the file.");
            e.getMessage();
            e.printStackTrace();
        }
        
        return users; //return list of all users
    }
    
    public static void clearFile(String filepath) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
        // This will effectively clear the file's contents by overwriting it with nothing
        bw.write(""); 
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    //to check uniqueID
    public static boolean isUserIDUnique(ArrayList<adminUserRegistrationClass> users, String userID){
        for(adminUserRegistrationClass user : users){
            if(user.getUserID().equals(userID))
                return false;
        }
        return true;
    }
    
}
