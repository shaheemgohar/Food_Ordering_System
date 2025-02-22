package Adminn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Shaheem
 */

public class adminUserRegistrationSubClass extends adminUserRegistrationClass {

    ArrayList<adminUserRegistrationClass> Registeruser;
    
    //constructor
    public adminUserRegistrationSubClass(String userID, String username, String password, String name, String phone, String rolecb, String balance) {
        super(userID, username, password, name, phone, rolecb, balance);
        Registeruser = new ArrayList<>();
    }

    //methods
    
    //to add user to file
    
    public void addUser(adminUserRegistrationClass user){
        Registeruser.add(user);
      }
    
    public void saveUsersToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            for (adminUserRegistrationClass user : Registeruser) {
                bw.write(user.toString());
                bw.newLine();  // Adds a new line after each user entry
            }
                        
            System.out.println("Users saved to file successfully.");
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving users to the file.");
            e.printStackTrace();
        }
    }
    
}
