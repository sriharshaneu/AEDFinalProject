package starting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import menuItems.Menu;
import khakejaorestaurant.User;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import managerPackage.Announcement;
import managerPackage.Manager;
import managerPackage.WelcomeManager;
import menuItems.Inventory;
import menuItems.MainMenu;

/**
 *
 * @author sreyasborra
 */
public class HomepageForm extends javax.swing.JFrame 
{
    public static ArrayList<Announcement> offers;
    RolesLoginWindow roles;
    RolesSignUpWindow rolesSignUp;
    /**
     * Creates new form HomepageForm
     */
    public HomepageForm() 
    {
        initComponents();
     
        MainMenu.categoryList.clear();
        MainMenu mainmenu = new MainMenu(); 
        mainmenu.setCategoryItem(); //load main menu
        Inventory inventory = new Inventory();
        inventory.setInventoryItems(); //load inventory
        offers = new ArrayList<>();
        User.viewAnnouncements(); //load offers
        //this.setState(this.ICONIFIED); //minimize
        //System.exit(0); 
    }
    public HomepageForm(boolean b) 
    {
        initComponents();
        
       
    }






public void setComponent(Component component) {
setContentPane((Container) component);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WorkArea = new javax.swing.JPanel();
        pHeader = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        btnMenuHomePage = new javax.swing.JButton();
        lblHomeImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gusto Restaurant");
        setBackground(new java.awt.Color(0, 51, 51));
        setIconImages(null);
        setLocation(new java.awt.Point(100, 100));
        setMinimumSize(new java.awt.Dimension(1217, 871));
        setName("HomePage"); // NOI18N
        getContentPane().setLayout(null);

        pHeader.setBackground(new java.awt.Color(255, 213, 0));
        pHeader.setMinimumSize(new java.awt.Dimension(1220, 80));
        pHeader.setName("pHeader"); // NOI18N
        pHeader.setPreferredSize(new java.awt.Dimension(1220, 80));
        pHeader.setLayout(null);

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Rockwell Condensed", 0, 52)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(127, 72, 101));
        lbLogo.setText("Khake Jao");
        lbLogo.setToolTipText("");
        pHeader.add(lbLogo);
        lbLogo.setBounds(29, 13, 190, 62);

        btnLogin.setBackground(new java.awt.Color(255, 213, 0));
        btnLogin.setFont(new java.awt.Font("Rockwell", 0, 30)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(127, 72, 101));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setPreferredSize(new java.awt.Dimension(87, 29));
        btnLogin.setRequestFocusEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pHeader.add(btnLogin);
        btnLogin.setBounds(890, 20, 130, 50);

        btnSignup.setBackground(new java.awt.Color(255, 213, 0));
        btnSignup.setFont(new java.awt.Font("Rockwell", 0, 30)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(127, 72, 101));
        btnSignup.setText("SIGNUP");
        btnSignup.setToolTipText("");
        btnSignup.setBorder(null);
        btnSignup.setBorderPainted(false);
        btnSignup.setContentAreaFilled(false);
        btnSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignup.setName(""); // NOI18N
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        pHeader.add(btnSignup);
        btnSignup.setBounds(1070, 20, 121, 50);

        btnMenuHomePage.setBackground(new java.awt.Color(255, 213, 0));
        btnMenuHomePage.setFont(new java.awt.Font("Rockwell", 0, 30)); // NOI18N
        btnMenuHomePage.setForeground(new java.awt.Color(127, 72, 101));
        btnMenuHomePage.setText("MENU");
        btnMenuHomePage.setBorder(null);
        btnMenuHomePage.setBorderPainted(false);
        btnMenuHomePage.setContentAreaFilled(false);
        btnMenuHomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuHomePage.setPreferredSize(new java.awt.Dimension(87, 29));
        btnMenuHomePage.setRequestFocusEnabled(false);
        btnMenuHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuHomePageActionPerformed(evt);
            }
        });
        pHeader.add(btnMenuHomePage);
        btnMenuHomePage.setBounds(720, 20, 140, 50);

        WorkArea.add(pHeader);

        lblHomeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Pic/food.png"))); // NOI18N
        lblHomeImage.setMaximumSize(new java.awt.Dimension(1500, 667));
        lblHomeImage.setMinimumSize(new java.awt.Dimension(1500, 667));
        lblHomeImage.setPreferredSize(new java.awt.Dimension(1500, 667));
        WorkArea.add(lblHomeImage);

        getContentPane().add(WorkArea);
        WorkArea.setBounds(0, 0, 1220, 870);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

WorkArea = new JPanel();
        setContentPane(WorkArea);
        roles = new RolesLoginWindow(this);
        WorkArea.add(roles);
        
        setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        rolesSignUp = new RolesSignUpWindow(this);
        WorkArea = new JPanel();
        setContentPane(WorkArea);
        WorkArea.add(rolesSignUp);
        setVisible(true);
        
        //this.dispose();
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnMenuHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuHomePageActionPerformed
        // TODO add your handling code here:
        Menu m=new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnMenuHomePageActionPerformed

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
            java.util.logging.Logger.getLogger(HomepageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomepageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomepageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomepageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new HomepageForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel WorkArea;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMenuHomePage;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lblHomeImage;
    private javax.swing.JPanel pHeader;
    // End of variables declaration//GEN-END:variables
}