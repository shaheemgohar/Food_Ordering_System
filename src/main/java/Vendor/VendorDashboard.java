
package Vendor;

import javax.swing.*;
import java.awt.*;

public class VendorDashboard extends javax.swing.JFrame 
{
    private String vendorId;
    private String vendorName;
    
    
    

    public VendorDashboard(String vendorId, String vendorName) 
    {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        setTitle("Vendor Dashboard - " + vendorName);
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        
        JPanel mainPanel = new JPanel(new GridLayout(5, 1));
        
        
        
        
        JButton btnItems = new JButton("Manage Items");
        JButton btnOrders = new JButton("Manage Orders");
        JButton btnHistory = new JButton("Order History");
        JButton btnReviews = new JButton("Customer Reviews");
        JButton btnRevenue = new JButton("Revenue Dashboard");
        
        
        
        btnItems.addActionListener(e -> new ItemManagement(vendorId).setVisible(true));
        btnOrders.addActionListener(e -> new OrderManagement(vendorId).setVisible(true));
        btnHistory.addActionListener(e -> new OrderHistory(vendorId).setVisible(true));
        btnReviews.addActionListener(e -> new CustomerReviews(vendorId).setVisible(true));
        btnRevenue.addActionListener(e -> new RevenueDashboard(vendorId).setVisible(true));
        
        
        
        
        mainPanel.add(btnItems);
        mainPanel.add(btnOrders);
        mainPanel.add(btnHistory);
        mainPanel.add(btnReviews);
        mainPanel.add(btnRevenue);
        
        
        add(mainPanel);
        
        
    }
    
    public static void main(String[] args) 
    {
        new VendorDashboard("v102", "Ahmed Bin Faisal").setVisible(true);
        
        
        
        
    }
    
    
    
}