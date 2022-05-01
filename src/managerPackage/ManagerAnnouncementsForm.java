/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerPackage;

import menuItems.Menu;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menuItems.Inventory;
import menuItems.InventoryForm;
import menuItems.MainMenu;
import menuItems.MenuItem;
import starting.HomepageForm;

/**
 *
 * @author sriha
 */
public class ManagerAnnouncementsForm extends javax.swing.JFrame
{
    /**
     * Creates new form ManagerAnnouncementsForm
     */
    Manager manager;
    String choice;
    ArrayList<MenuItem> offerItems = new ArrayList<>();
    //public static ArrayList<Announcement> announcements = new ArrayList<>();
    

    public ManagerAnnouncementsForm()
    {
        this.setLocationRelativeTo(null); //center form in screen
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void fillComboBox()
    {
        cbxAnnFoodItems.removeAllItems();
        ArrayList<MenuItem> foodItems = MainMenu.categoryList.get(choice);
        for (int i = 0; i < foodItems.size(); ++i)
        {
            String itemName = foodItems.get(i).getItemName();
            cbxAnnFoodItems.addItem(itemName);
        }
    }

    /**
     *
     * @param m
     * @throws SQLException
     */
    public ManagerAnnouncementsForm(Manager m) throws SQLException
    {
        initComponents();
        this.manager = m;
        this.setLocationRelativeTo(null); //center form in screen
        tbl_viewItems.setVisible(false);
        tbl_viewItems.getTableHeader().setFont(new Font("Rockwell", Font.BOLD, 20));
        cbxAnnFoodItems.setModel(new DefaultComboBoxModel<>(new String[]
        {
            ""
        }));
        cbxAnnFoodItems.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHeader = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        btnInventoryManager = new javax.swing.JButton();
        btnMakeAnnouncement = new javax.swing.JButton();
        btnMenuManager = new javax.swing.JButton();
        pnlAnnouncement = new javax.swing.JPanel();
        cbx_viewitem = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_viewItems = new javax.swing.JTable();
        lblMessage = new javax.swing.JLabel();
        btnAddItemAnn = new javax.swing.JButton();
        cbxAnnFoodItems = new javax.swing.JComboBox();
        btnMakeAnn = new javax.swing.JButton();
        lbl_itemName1 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lbl_itemName2 = new javax.swing.JLabel();
        lbl_itemName3 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1217, 871));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pHeader.setBackground(new java.awt.Color(255, 213, 0));
        pHeader.setName("pHeader"); // NOI18N
        pHeader.setPreferredSize(new java.awt.Dimension(1062, 70));
        pHeader.setLayout(null);

        btnLogout.setBackground(new java.awt.Color(255, 213, 0));
        btnLogout.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(127, 72, 101));
        btnLogout.setText("Log out");
        btnLogout.setToolTipText("");
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setName(""); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pHeader.add(btnLogout);
        btnLogout.setBounds(1090, 30, 101, 29);

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Rockwell Condensed", 0, 52)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(127, 72, 101));
        lbLogo.setText("Khake Jao");
        lbLogo.setToolTipText("");
        pHeader.add(lbLogo);
        lbLogo.setBounds(40, 10, 220, 62);

        btnInventoryManager.setBackground(new java.awt.Color(255, 213, 0));
        btnInventoryManager.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        btnInventoryManager.setForeground(new java.awt.Color(127, 72, 101));
        btnInventoryManager.setText("Track Inventory");
        btnInventoryManager.setBorder(null);
        btnInventoryManager.setBorderPainted(false);
        btnInventoryManager.setContentAreaFilled(false);
        btnInventoryManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventoryManager.setPreferredSize(new java.awt.Dimension(87, 29));
        btnInventoryManager.setRequestFocusEnabled(false);
        btnInventoryManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryManagerActionPerformed(evt);
            }
        });
        pHeader.add(btnInventoryManager);
        btnInventoryManager.setBounds(900, 30, 184, 29);

        btnMakeAnnouncement.setBackground(new java.awt.Color(255, 213, 0));
        btnMakeAnnouncement.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        btnMakeAnnouncement.setForeground(new java.awt.Color(127, 72, 101));
        btnMakeAnnouncement.setText("Make Announcement");
        btnMakeAnnouncement.setBorder(null);
        btnMakeAnnouncement.setBorderPainted(false);
        btnMakeAnnouncement.setContentAreaFilled(false);
        btnMakeAnnouncement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMakeAnnouncement.setPreferredSize(new java.awt.Dimension(87, 29));
        btnMakeAnnouncement.setRequestFocusEnabled(false);
        btnMakeAnnouncement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeAnnouncementActionPerformed(evt);
            }
        });
        pHeader.add(btnMakeAnnouncement);
        btnMakeAnnouncement.setBounds(630, 30, 255, 29);

        btnMenuManager.setBackground(new java.awt.Color(255, 213, 0));
        btnMenuManager.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        btnMenuManager.setForeground(new java.awt.Color(127, 72, 101));
        btnMenuManager.setText("Main Menu");
        btnMenuManager.setBorder(null);
        btnMenuManager.setBorderPainted(false);
        btnMenuManager.setContentAreaFilled(false);
        btnMenuManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuManager.setPreferredSize(new java.awt.Dimension(87, 29));
        btnMenuManager.setRequestFocusEnabled(false);
        btnMenuManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuManagerActionPerformed(evt);
            }
        });
        pHeader.add(btnMenuManager);
        btnMenuManager.setBounds(470, 30, 153, 29);

        getContentPane().add(pHeader);
        pHeader.setBounds(0, 0, 1220, 80);

        pnlAnnouncement.setBackground(new java.awt.Color(255, 255, 255));
        pnlAnnouncement.setMinimumSize(new java.awt.Dimension(1261, 788));
        pnlAnnouncement.setPreferredSize(new java.awt.Dimension(1261, 788));
        pnlAnnouncement.setLayout(null);

        cbx_viewitem.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        cbx_viewitem.setForeground(new java.awt.Color(102, 0, 102));
        cbx_viewitem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Appetizers", "Pasta", "Burger", "Pizza", "Drinks", "Desserts" }));
        cbx_viewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_viewitemActionPerformed(evt);
            }
        });
        pnlAnnouncement.add(cbx_viewitem);
        cbx_viewitem.setBounds(530, 310, 310, 40);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_viewItems.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tbl_viewItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Item Rank", "Units Sold", "Quantity Avaliable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_viewItems);

        pnlAnnouncement.add(jScrollPane1);
        jScrollPane1.setBounds(40, 370, 1160, 165);

        lblMessage.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setText("Please enter the message you want to accompany the offer with:");
        pnlAnnouncement.add(lblMessage);
        lblMessage.setBounds(40, 20, 880, 50);

        btnAddItemAnn.setBackground(new java.awt.Color(255, 255, 255));
        btnAddItemAnn.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        btnAddItemAnn.setForeground(new java.awt.Color(102, 0, 102));
        btnAddItemAnn.setText("Add Item");
        btnAddItemAnn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddItemAnn.setPreferredSize(new java.awt.Dimension(169, 37));
        btnAddItemAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemAnnActionPerformed(evt);
            }
        });
        pnlAnnouncement.add(btnAddItemAnn);
        btnAddItemAnn.setBounds(700, 620, 350, 40);

        cbxAnnFoodItems.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        cbxAnnFoodItems.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAnnFoodItems.setSelectedItem("");
        cbxAnnFoodItems.setName(""); // NOI18N
        pnlAnnouncement.add(cbxAnnFoodItems);
        cbxAnnFoodItems.setBounds(700, 560, 350, 40);

        btnMakeAnn.setBackground(new java.awt.Color(255, 255, 255));
        btnMakeAnn.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        btnMakeAnn.setForeground(new java.awt.Color(102, 0, 102));
        btnMakeAnn.setText("Make Announcement");
        btnMakeAnn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMakeAnn.setPreferredSize(new java.awt.Dimension(169, 37));
        btnMakeAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeAnnActionPerformed(evt);
            }
        });
        pnlAnnouncement.add(btnMakeAnn);
        btnMakeAnn.setBounds(400, 670, 350, 70);

        lbl_itemName1.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        lbl_itemName1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_itemName1.setText("Please enter offer price:");
        pnlAnnouncement.add(lbl_itemName1);
        lbl_itemName1.setBounds(40, 200, 350, 50);

        txtPrice.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        pnlAnnouncement.add(txtPrice);
        txtPrice.setBounds(410, 200, 210, 50);

        lbl_itemName2.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        lbl_itemName2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_itemName2.setText("Choose food item you want to add to the offer:");
        pnlAnnouncement.add(lbl_itemName2);
        lbl_itemName2.setBounds(40, 560, 630, 50);

        lbl_itemName3.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        lbl_itemName3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_itemName3.setText("Choose your desired Category:");
        pnlAnnouncement.add(lbl_itemName3);
        lbl_itemName3.setBounds(40, 300, 440, 50);

        txtMessage.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        pnlAnnouncement.add(txtMessage);
        txtMessage.setBounds(40, 90, 860, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managerPackage/Food-Inventory-Management-What-It-Is-and-How-to-Do-It-Well-1.jpg"))); // NOI18N
        pnlAnnouncement.add(jLabel1);
        jLabel1.setBounds(1, 0, 1220, 790);

        getContentPane().add(pnlAnnouncement);
        pnlAnnouncement.setBounds(0, 74, 1261, 788);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogoutActionPerformed
    {//GEN-HEADEREND:event_btnLogoutActionPerformed
        HomepageForm homepage = new HomepageForm(true);
        homepage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMakeAnnouncementActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMakeAnnouncementActionPerformed
    {//GEN-HEADEREND:event_btnMakeAnnouncementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMakeAnnouncementActionPerformed

    private void btnInventoryManagerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnInventoryManagerActionPerformed
    {//GEN-HEADEREND:event_btnInventoryManagerActionPerformed
        try
        {
            // TODO add your handling code here:
            InventoryForm inv = new InventoryForm(manager);
            inv.setVisible(true);
            this.dispose();
        } catch (SQLException ex)
        {
            Logger.getLogger(ManagerWelcomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInventoryManagerActionPerformed

    private void btnMenuManagerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMenuManagerActionPerformed
    {//GEN-HEADEREND:event_btnMenuManagerActionPerformed
        // TODO add your handling code here:
        
        Menu m=new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnMenuManagerActionPerformed

    private void cbx_viewitemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cbx_viewitemActionPerformed
    {//GEN-HEADEREND:event_cbx_viewitemActionPerformed
        tbl_viewItems.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) tbl_viewItems.getModel();
        model.setRowCount(0);
        choice = (String) cbx_viewitem.getSelectedItem();
        String itemName;
        fillComboBox();
        try
        {
             //Getting Inventory Info from Inventory List And Display it on table
            //Getting Menu Item Info from Main Menu Item And Display it on table
            
            for (int i = 0; i < MainMenu.categoryList.get(choice).size(); ++i)
            {
                itemName = MainMenu.categoryList.get(choice).get(i).getItemName();
                model.addRow(new Object[]
                {
                    MainMenu.categoryList.get(choice).get(i).getItemId(), MainMenu.categoryList.get(choice).get(i).getItemName(),
                    MainMenu.categoryList.get(choice).get(i).getItemRate(), Inventory.inventoryList.get(itemName).getSoldMenuItem(), Inventory.inventoryList.get(MainMenu.categoryList.get(choice).get(i).getItemName()).getAvaliableMenuItem()
                });
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please Choose a Category");
        }
    }//GEN-LAST:event_cbx_viewitemActionPerformed

    private void btnAddItemAnnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddItemAnnActionPerformed
    {//GEN-HEADEREND:event_btnAddItemAnnActionPerformed
        try
        {
            String foodItem = (String) cbxAnnFoodItems.getSelectedItem(); //selected item name
            ArrayList<MenuItem> foodItems = MainMenu.categoryList.get(choice);
            MenuItem offerItem = new MenuItem(); //selected item
            for (int i = 0; i < foodItems.size(); ++i)
            {
                String itemName = foodItems.get(i).getItemName();
                if (itemName.equals(foodItem))
                {
                    offerItem = foodItems.get(i); //get whole object
                    break;
                }
            }
            offerItems.add(offerItem);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddItemAnnActionPerformed

    private void btnMakeAnnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMakeAnnActionPerformed
    {//GEN-HEADEREND:event_btnMakeAnnActionPerformed
        try
        {
            String message = txtMessage.getText();
            String priceS = txtPrice.getText();
            int price = 0;
            if (!message.isEmpty() && !priceS.isEmpty() && !offerItems.isEmpty())
            {
                try
                {
                    price = Integer.valueOf(priceS);
                    if (price < 0)
                    {
                        txtPrice.setText("");
                        JOptionPane.showMessageDialog(this, "Please enter a valid price", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        Announcement announcement = new Announcement(manager.getName(), message, price, offerItems);
                        //announcements.add(announcement);
                        manager.addAnnouncement(announcement);
                        JOptionPane.showMessageDialog(this, "Offer added successfully", "New Offer", JOptionPane.INFORMATION_MESSAGE);
                        //calll add in mang
                    }
                } catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(this, "Please enter a valid price", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    txtPrice.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please enter all required data", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMakeAnnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ManagerAnnouncementsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManagerAnnouncementsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManagerAnnouncementsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManagerAnnouncementsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ManagerAnnouncementsForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItemAnn;
    private javax.swing.JButton btnInventoryManager;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMakeAnn;
    private javax.swing.JButton btnMakeAnnouncement;
    private javax.swing.JButton btnMenuManager;
    private javax.swing.JComboBox cbxAnnFoodItems;
    private javax.swing.JComboBox<String> cbx_viewitem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lbl_itemName1;
    private javax.swing.JLabel lbl_itemName2;
    private javax.swing.JLabel lbl_itemName3;
    public static javax.swing.JPanel pHeader;
    private javax.swing.JPanel pnlAnnouncement;
    private javax.swing.JTable tbl_viewItems;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
