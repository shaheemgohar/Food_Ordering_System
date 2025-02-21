package Adminn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * @author Shaheem
 */
public class adminUserRegistration extends javax.swing.JFrame implements adminTableMusts {
    
    //attributes
        String userID;
        String username;
        String password;
        String name;
        String phone;
        String role;
        String filepath = "registeredusers.txt";

    public adminUserRegistration() {
        initComponents();
        refreshData();
    }

    @Override
    public void refreshData() {
        try{
        DefaultTableModel model = (DefaultTableModel) userRegistrationTable.getModel();
        model.setRowCount(0);
        
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split(";");
            
            model.addRow(new Object[]{  //creating an array of objects 
                data[0], data[1], data[2], data[3], data[4], data[5]
            });
        }
        br.close();
                
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nametxt = new javax.swing.JTextField();
        backbtn = new javax.swing.JButton();
        phonetxt = new javax.swing.JTextField();
        userIDtxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        rolecb = new javax.swing.JComboBox<>();
        addbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userRegistrationTable = new javax.swing.JTable();
        helpbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        phonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetxtActionPerformed(evt);
            }
        });

        rolecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendor", "Customer", "Runner" }));

        addbtn.setBackground(new java.awt.Color(204, 255, 204));
        addbtn.setForeground(new java.awt.Color(0, 0, 0));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("UserID");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Phone");

        jLabel5.setText("Name");

        jLabel6.setText("Role");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("User Registration");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Registered Users");

        updatebtn.setBackground(new java.awt.Color(255, 153, 102));
        updatebtn.setForeground(new java.awt.Color(0, 0, 0));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setBackground(new java.awt.Color(255, 204, 204));
        deletebtn.setForeground(new java.awt.Color(0, 0, 0));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        userRegistrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "Password", "Name", "Phone", "Role"
            }
        ));
        userRegistrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userRegistrationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userRegistrationTable);

        helpbtn.setText("?");
        helpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernametxt)
                                        .addComponent(userIDtxt)
                                        .addComponent(passwordtxt)
                                        .addComponent(rolecb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(phonetxt)
                                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addComponent(helpbtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(190, 190, 190))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(198, 198, 198))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(userIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(phonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rolecb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpbtn)
                            .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 94, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        new adminHomePage().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void phonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetxtActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        this.userID = (String) userIDtxt.getText();
        this.username = (String) usernametxt.getText();
        this.password = new String(passwordtxt.getPassword());
        this.name = (String) nametxt.getText();
        this.phone = (String) phonetxt.getText();
        this.role = (String) rolecb.getSelectedItem().toString();
        String balance = "0";
        //to check for unique ID
        adminUserRegistrationSubClass user;
        //storing all the users
        ArrayList<adminUserRegistrationClass> users = adminFileHandler.readFromFile(filepath);

        if(adminFileHandler.isUserIDUnique(users, userID)){
//        if(role.equals("Customer")){
        user = new adminUserRegistrationSubClass(this.userID, this.username, this.password, this.name, this.phone, this.role, balance);
//        }else{
//        user = new adminUserRegistrationSubClass(this.userID, this.username, this.password, this.name, this.phone, this.role, balance);
//        }
        user.addUser(user);
        user.saveUsersToFile("registeredusers.txt");
        
        
        JOptionPane.showMessageDialog(null, "User added successfully!");
        }else{
            JOptionPane.showMessageDialog(null, "Error: The user ID '" + this.userID + "' is already taken. Please choose a unique ID.");
        }
        
        refreshData();
    }//GEN-LAST:event_addbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
       try{
         int SelectedRow = userRegistrationTable.getSelectedRow();
         if(SelectedRow != -1){
         DefaultTableModel model = (DefaultTableModel) userRegistrationTable.getModel();
         
         //search which user to update
            String userIDtoUpdate = (String) model.getValueAt(SelectedRow,0);
            
            String newUserID = userIDtxt.getText();
            String newUsername = usernametxt.getText();
            String newPassword = new String(passwordtxt.getPassword());
            String newName = nametxt.getText();
            String newPhone = phonetxt.getText();
            String newRole = (String) rolecb.getSelectedItem(); 
            
            
            
            ArrayList<adminUserRegistrationClass> users = adminFileHandler.readFromFile(filepath);
            boolean userFound = false;
            for (adminUserRegistrationClass user : users) {
                if (user.getUserID().equals(userIDtoUpdate)) {
                    // Update the user's details
                    user.setUserID(newUserID);
                    user.setUsername(newUsername);
                    user.setPassword(newPassword);
                    user.setName(newName);
                    user.setPhone(newPhone);
                    user.setRolecb(newRole);
                  
                    // Mark that we found the user and updated their data
                    userFound = true;
                    break;
                }
            }

            if (userFound) {
                // After updating, clear the file content
                adminFileHandler.clearFile(filepath);

                // Write all the updated users back to the file
                for (adminUserRegistrationClass updateduser : users) {
                    adminFileHandler.writeToFile(updateduser,filepath);
                }
                JOptionPane.showMessageDialog(null, "User updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "User ID not found in file.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No user selected in the table");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
       refreshData();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       {                                          
              
        //delete selected row in table
                try{
                  int SelectedRow = userRegistrationTable.getSelectedRow();
                  if(SelectedRow != -1){
                      DefaultTableModel model = (DefaultTableModel) userRegistrationTable.getModel();
                      model.removeRow(SelectedRow);
                      JOptionPane.showMessageDialog(null, "User Deleted!");
                  }else{
                      JOptionPane.showMessageDialog(null, "No user selected");
                  }
                                   
                
              //deleting selected row in file
              //reading lines from the file
                  
                  BufferedReader br = new BufferedReader(new FileReader(filepath));
                  StringBuilder filecontent = new StringBuilder();
                  String line;
                  
                  //counter of index starting from 0 when rows are selected
                  int currentLineIndex = 0;
                                   
                  while((line =br.readLine()) != null ){
                      //we save the lines that aren't selected
                      //if the current line index matches the selectedRow index, we skip the if block and only +1 currentLineIndex
                      if(currentLineIndex != SelectedRow){
                          filecontent.append(line).append("\n");
                      }
                      currentLineIndex++;
                  }
                  br.close();
                  //writng the content into the file
                  FileWriter fw = new FileWriter(filepath);
                  fw.write(filecontent.toString());
                  fw.close();
                                  
              }catch(IOException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.getMessage());
              }
              
              
    }                          
    }//GEN-LAST:event_deletebtnActionPerformed

    private void helpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtnActionPerformed

    private void userRegistrationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userRegistrationTableMouseClicked
        populateFormTableSelection();
    }//GEN-LAST:event_userRegistrationTableMouseClicked
    
    private void populateFormTableSelection(){
        int SelectedRow = userRegistrationTable.getSelectedRow();
        if(SelectedRow != -1){
                String userID = (String) userRegistrationTable.getValueAt(SelectedRow, 0);
                String username = (String) userRegistrationTable.getValueAt(SelectedRow, 1);
                String password = (String) userRegistrationTable.getValueAt(SelectedRow, 2);
                String name = (String) userRegistrationTable.getValueAt(SelectedRow, 3);
                String phone = (String) userRegistrationTable.getValueAt(SelectedRow, 4);
                String role = (String) userRegistrationTable.getValueAt(SelectedRow, 5);
                
                userIDtxt.setText(userID);
                usernametxt.setText(username);
                passwordtxt.setText(password);
                nametxt.setText(name);
                phonetxt.setText(phone);
                rolecb.setSelectedItem(role);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton helpbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JTextField phonetxt;
    private javax.swing.JComboBox<String> rolecb;
    private javax.swing.JButton updatebtn;
    private javax.swing.JTextField userIDtxt;
    private javax.swing.JTable userRegistrationTable;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
