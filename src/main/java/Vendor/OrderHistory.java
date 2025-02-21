
package Vendor;






import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHistory extends javax.swing.JFrame {
    private String vendorId;
    private JPanel mainPanel;
    private String[] orderColumns = {"Order ID", "Customer", "Date", "Total", "Status", "Review"};

    public OrderHistory(String vendorId) {
        this.vendorId = vendorId;
        setTitle("Order History");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        
        JComboBox<String> filter = new JComboBox<>(new String[]{"All", "Daily", "Monthly", "Quarterly"});
        JButton btnFilter = new JButton("Filter");
        
        btnFilter.addActionListener(e -> refreshTable((String) filter.getSelectedItem()));
        
        JTable ordersTable = new JTable(loadOrders("All"), orderColumns);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        
        JPanel filterPanel = new JPanel();
        filterPanel.add(filter);
        filterPanel.add(btnFilter);
        
        mainPanel.add(filterPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
    }

    private Object[][] loadOrders(String filter) 
    {
        ArrayList<Object[]> orders = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("orders.txt"))) 
        {
            while (scanner.hasNextLine()) 
            {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId) && matchesFilter(data[2], filter)) 
                {
                    orders.add(new Object[]{data[1], data[2], data[3], data[4], data[5], data[6]});

                }
            }
        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders.toArray(new Object[0][]);
    }

    private boolean matchesFilter(String orderDate, String filter) 
    {
        if (filter.equals("All")) return true;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderLocalDate = LocalDate.parse(orderDate, formatter);
        LocalDate today = LocalDate.now();
        
        switch (filter) {
            case "Daily": return orderLocalDate.equals(today);
            case "Monthly": return orderLocalDate.getMonthValue() == today.getMonthValue() && orderLocalDate.getYear() == today.getYear();
            case "Quarterly": 
                int q1 = (today.getMonthValue() - 1) / 3;
                int q2 = (orderLocalDate.getMonthValue() - 1) / 3;
                return q1 == q2 && orderLocalDate.getYear() == today.getYear();
            default: return false;
        }
    }

    private void refreshTable(String filter) 
    {
        Object[][] ordersData = loadOrders(filter);
        JTable newTable = new JTable(ordersData, orderColumns);
        JScrollPane newScrollPane = new JScrollPane(newTable);
        
        mainPanel.remove(1);
        mainPanel.add(newScrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}