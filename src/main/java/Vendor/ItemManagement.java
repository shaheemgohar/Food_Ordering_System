
package Vendor;




import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemManagement extends javax.swing.JFrame 
{
    private String vendorId;

    public ItemManagement(String vendorId) 
    {
        
        
        this.vendorId = vendorId;
        setTitle("Item Management");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        
        
        
        String[] itemColumns = {"Name", "Price", "Quantity"};

        
        
        
        
        Object[][] itemsData = loadItems();
        JTable itemsTable = new JTable(itemsData, itemColumns);
       
        
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        
        
        
        JPanel buttonsPanel = new JPanel();
        JButton btnAdd = new JButton("Add Item");
        JButton btnEdit = new JButton("Edit Item");
        JButton btnDelete = new JButton("Delete Item");
        
        
        
        btnAdd.addActionListener(e -> addItem());
        btnEdit.addActionListener(e -> editItem(itemsTable.getSelectedRow()));
        btnDelete.addActionListener(e -> deleteItem(itemsTable.getSelectedRow()));
        
        
        
        
        buttonsPanel.add(btnAdd);
        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnDelete);
        
        
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        
        
        add(mainPanel);
        
        
    }

    private Object[][] loadItems() 
    {
        ArrayList<Object[]> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("menuitems.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data[0].equals(vendorId)) {
                    items.add(new Object[]{data[1], data[2], data[3]});
                    
                    

                }
            }
            
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return items.toArray(new Object[0][]);
    }

    private void addItem() 
    
    
    {
        JTextField nameField = new JTextField(10);
        JSpinner priceSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 0.1));
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceSpinner);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantitySpinner);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Add Item", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) 
        {
            String name = nameField.getText().trim();
            if (name.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Name is required");
                return;
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("menuitems.txt", true))) 
            {
                writer.println(vendorId + ";" + name + ";" + priceSpinner.getValue() + ";" + quantitySpinner.getValue());
                JOptionPane.showMessageDialog(this, "Item added");
                new ItemManagement(vendorId).setVisible(true);
                dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void editItem(int row) 
    {
        if (row < 0) return;
        Object[][] items = loadItems();
        if (items.length <= row) return;
        
        String name = (String) items[row][0];
        double price = Double.parseDouble(items[row][1].toString());
        int quantity = Integer.parseInt(items[row][2].toString());
        
        JTextField nameField = new JTextField(name);
        JSpinner priceSpinner = new JSpinner(new SpinnerNumberModel(price, 0.0, Double.MAX_VALUE, 0.1));
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(quantity, 0, Integer.MAX_VALUE, 1));
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceSpinner);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantitySpinner);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Item", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) 
        {
            String newName = nameField.getText().trim();
            if (newName.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Name is required");
                return;
            }
            try 
            {
                List<String> lines = new ArrayList<>();
                try (Scanner scanner = new Scanner(new File("menuitems.txt"))) 
                {
                    while (scanner.hasNextLine()) 
                    {
                        String line = scanner.nextLine();
                        String[] data = line.split(";");
                        if (data[0].equals(vendorId) && data[1].equals(name)) 
                        {
                            lines.add(vendorId + ";" + newName + ";" + priceSpinner.getValue() + ";" + quantitySpinner.getValue());
                        } else {
                            lines.add(line);
                        }
                    }
                }
                try (PrintWriter writer = new PrintWriter(new FileWriter("menuitems.txt"))) 
                {
                    for (String line : lines) writer.println(line);
                    JOptionPane.showMessageDialog(this, "Item updated");
                    new ItemManagement(vendorId).setVisible(true);
                    dispose();
                }
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    private void deleteItem(int row) 
    {
        if (row < 0) return;
        Object[][] items = loadItems();
        if (items.length <= row) return;
        
        String name = (String) items[row][0];
        int confirm = JOptionPane.showConfirmDialog(this, "Delete " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) 
        {
            try 
            {
                List<String> lines = new ArrayList<>();
                try (Scanner scanner = new Scanner(new File("menuitems.txt"))) 
                {
                    while (scanner.hasNextLine()) 
                    {
                        String line = scanner.nextLine();
                        String[] data = line.split(";");
                        if (!(data[0].equals(vendorId) && data[1].equals(name))) 
                        {
                            lines.add(line);
                        }
                    }
                }
                try (PrintWriter writer = new PrintWriter(new FileWriter("menuitems.txt"))) 
                {
                    for (String line : lines) writer.println(line);
                    JOptionPane.showMessageDialog(this, "Item deleted");
                    new ItemManagement(vendorId).setVisible(true);
                    dispose();
                }
                
                
                
            } catch (IOException e) 
            {
                e.printStackTrace();
                
                
            }
            
            
            
        }
    }
    
    
}