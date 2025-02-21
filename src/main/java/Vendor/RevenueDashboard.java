package Vendor;





import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class RevenueDashboard extends javax.swing.JFrame 
{
    private String vendorId;

    public RevenueDashboard(String vendorId) 
    {
        this.vendorId = vendorId;
        setTitle("Revenue Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        
        JLabel total = new JLabel("Total: $" + calculateTotal());
        JLabel daily = new JLabel("Daily: $" + calculateDaily());
        JLabel monthly = new JLabel("Monthly: $" + calculateMonthly());
        
        mainPanel.add(total);
        mainPanel.add(daily);
        mainPanel.add(monthly);
        
        add(mainPanel);
    }

    private double calculateTotal() 
    {
        double total = 0;
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) 
            {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId)) 
                {
                    total += Double.parseDouble(data[3]);
                }
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            
            
        }
        return total;
        
        
    }

    private double calculateDaily() 
    {
        double total = 0;
        String today = LocalDate.now().toString();
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId) && data[2].equals(today)) 
                {
                    total += Double.parseDouble(data[3]);
                }
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            
        }
        
        return total;
    }

    private double calculateMonthly() 
    {
        double total = 0;
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId)) {
                    LocalDate orderDate = LocalDate.parse(data[2]);
                    if (orderDate.getYear() == year && orderDate.getMonthValue() == month) 
                    {
                        total += Double.parseDouble(data[3]);
                        
                        
                    }
                }
                
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            
            
        }
        return total;
    }
}