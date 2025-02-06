package Adminn;

/**
 * @author Shaheem
 */

public abstract class adminUserRegistrationClass {
    
    //attributes
    protected String userID;
    protected String username;
    protected String password;
    protected String name;
    protected String phone;
    protected String rolecb;
    protected String balance;

    //constructors overloaded
    public adminUserRegistrationClass(){
        
    }
    //for customer
    public adminUserRegistrationClass(String userID, String username, String password, String name, String phone, String rolecb, String balance) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.rolecb = rolecb;
        this.balance = balance;
    }


    
    //method
    
    @Override
    public String toString(){
        return userID + ";"+ username + ";" + password + ";" + name + ";" + phone + ";" + rolecb + ";"+ balance + ";";
    }
    //to Override
    public void addUser() {
        return;
    }
    
    //getters
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRolecb() {
        return rolecb;
    }

    public String getBalance() {
        return balance;
    }

    //setters for updating 

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRolecb(String rolecb) {
        this.rolecb = rolecb;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    
   
    
}
