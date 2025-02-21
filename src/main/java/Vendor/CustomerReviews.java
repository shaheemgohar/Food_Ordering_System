
package Vendor;



import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class CustomerReviews extends javax.swing.JFrame 
{
    
    
    private String vendorId;

    
    
    public CustomerReviews(String vendorId) 
    {
        this.vendorId = vendorId;
        setTitle("Customer Reviews");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        
        JTextArea reviews = new JTextArea();
        reviews.setEditable(false);
        
        
        Set<String> vendorOrderIds = loadVendorOrderIds();
        
        
        try (Scanner scanner = new Scanner(new File("reviews.txt"))) 
        {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (vendorOrderIds.contains(data[1])) { 
                    reviews.append("Customer: " + data[2] + "\n");
                    reviews.append("Review: " + data[4] + "\n");
                    reviews.append("Rating: " + data[3] + "/5\n\n");
                }
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            
            
        }
        
        
        add(new JScrollPane(reviews));
        
    }

    private Set<String> loadVendorOrderIds() 
    {
        
        Set<String> orderIds = new HashSet<>();
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) 
            {
                
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId)) 
                {
                    orderIds.add(data[1]); 
                }
            }
        } catch (FileNotFoundException e) 
        {
            
            e.printStackTrace();
            
        }
        return orderIds;
    }
    
}