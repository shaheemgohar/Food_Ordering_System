
package Vendor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class OrderManagement extends javax.swing.JFrame 
{
    private String vendorId;

    public OrderManagement(String vendorId) 
    {
        this.vendorId = vendorId;
        setTitle("Order Management");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        
        String[] orderColumns = {"Order ID", "Customer", "Date", "Total", "Status", "Review"};

        Object[][] ordersData = loadOrders();
        JTable ordersTable = new JTable(ordersData, orderColumns);
        
        
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        
        
        
        JPanel buttonsPanel = new JPanel();
        JButton btnAccept = new JButton("Accept Order");
        JButton btnCancel = new JButton("Cancel Order");
        JButton btnUpdate = new JButton("Update Status");
        
        btnAccept.addActionListener(e -> acceptOrder(ordersTable.getSelectedRow()));
        btnCancel.addActionListener(e -> cancelOrder(ordersTable.getSelectedRow()));
        btnUpdate.addActionListener(e -> updateStatus(ordersTable.getSelectedRow()));
        
        
        
        buttonsPanel.add(btnAccept);
        buttonsPanel.add(btnCancel);
        buttonsPanel.add(btnUpdate);
        
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }

    private Object[][] loadOrders() 
    {
        ArrayList<Object[]> orders = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId)) {
                    orders.add(new Object[]{data[1], data[2], data[3], data[4], data[5]});
                    
                    
                }
                
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return orders.toArray(new Object[0][]);
        
        
        
    }

    private void acceptOrder(int row) 
    {
        if (row < 0) return;
        Object[][] orders = loadOrders();
        if (orders.length <= row) return;
        
        
        
        
        String orderId = (String) orders[row][0];
        String status = (String) orders[row][4];
        
        if (status.equals("Accepted")) {
            JOptionPane.showMessageDialog(this, "Order already accepted");
            return;
        }
        try {
            List<String> lines = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File("orders.txt"))) 
            {
                while (scanner.hasNextLine()) 
                {
                    String line = scanner.nextLine();
                    
                    String[] data = line.split(";");
                    if (data[0].equals(vendorId) && data[1].equals(orderId)) 
                    {
                        data[4] = "Accepted";
                        
                        
                    }
                    lines.add(String.join(";", data));
                    
                    
                    
                }
                
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt"))) 
            {
                for (String line : lines) writer.println(line);
                
                
                JOptionPane.showMessageDialog(this, "Order accepted");
                
                
                new OrderManagement(vendorId).setVisible(true);
                
                
                dispose();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
            
        }
        
        
    }

    private void cancelOrder(int row) 
    {
        if (row < 0) return;
        Object[][] orders = loadOrders();
        if (orders.length <= row) return;
        
        
        String orderId = (String) orders[row][0];
        String status = (String) orders[row][4];
        
        
        
        if (status.equals("Cancelled")) 
        {
            JOptionPane.showMessageDialog(this, "Order already cancelled");
            
            
            
            return;
            
            
        }
        try 
        {
            List<String> lines = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File("orders.txt"))) 
            {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(";");
                    if (data[0].equals(vendorId) && data[1].equals(orderId)) 
                    {
                        data[4] = "Cancelled";
                    }
                    lines.add(String.join(";", data));
                }
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt"))) 
            {
                for (String line : lines) writer.println(line);
                JOptionPane.showMessageDialog(this, "Order cancelled");
                new OrderManagement(vendorId).setVisible(true);
                dispose();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    private void updateStatus(int row) 
    {
        if (row < 0) return;
        Object[][] orders = loadOrders();
        if (orders.length <= row) return;
        
        String orderId = (String) orders[row][0];
        String[] options = {"Preparing", "Delivered", "Ready"};
        String newStatus = (String) JOptionPane.showInputDialog(this, "New status:", "Update", JOptionPane.QUESTION_MESSAGE, null, options, orders[row][4]);
        
        if (newStatus == null || newStatus.equals(orders[row][4])) return;
        
        try {
            List<String> lines = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File("orders.txt"))) 
            {
                while (scanner.hasNextLine()) 
                {
                    String line = scanner.nextLine();
                    String[] data = line.split(";");
                    if (data[0].equals(vendorId) && data[1].equals(orderId)) 
                    {
                        data[4] = newStatus;
                    }
                    lines.add(String.join(";", data));
                }
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt"))) 
            {
                for (String line : lines) writer.println(line);
                JOptionPane.showMessageDialog(this, "Status updated");
                new OrderManagement(vendorId).setVisible(true);
                dispose();
            }
        } catch (IOException e) 
            
            
        {
            e.printStackTrace();
            
            
        }
        
    }
    
}