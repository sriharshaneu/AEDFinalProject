/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package starting;

import customerPackage.Customer;
import customerPackage.MusicBandModel;
import customerPackage.Waitor;
import khakejaorestaurant.User;
import java.awt.Container;
import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import managerPackage.Manager;
import managerPackage.WelcomeManager;

/**
 *
 * @author prathik reddy arasu
 */
public class RoleLoginForm extends javax.swing.JPanel {

	/**
	 * Creates new form RoleLoginForm
	 */
	public RoleLoginForm() {
		initComponents();
	}
	String type;
	HomepageForm homeForm;

	public RoleLoginForm(String s, HomepageForm homeForm) {
		initComponents();
		this.homeForm = homeForm;
		txtPasswordLogin.setEchoChar('*');
		type = s;
	}

	public static void setTextFields() {
		txtUsernameLogin.setText("");
		txtPasswordLogin.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbUsernameLogin = new javax.swing.JLabel();
        txtUsernameLogin = new javax.swing.JTextField();
        lblPasswordLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPasswordLogin = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        lbLogo1 = new javax.swing.JLabel();

        PanelLogin.setBackground(new java.awt.Color(255, 255, 255));

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Rockwell Condensed", 0, 55)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(127, 72, 101));
        lbLogo.setText("Login");
        lbLogo.setToolTipText("");

        lbUsernameLogin.setFont(new java.awt.Font("Rockwell", 0, 22)); // NOI18N
        lbUsernameLogin.setText("Username");

        txtUsernameLogin.setFont(new java.awt.Font("Rockwell", 0, 22)); // NOI18N
        txtUsernameLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 72, 101)));
        txtUsernameLogin.setOpaque(false);
        txtUsernameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameLoginActionPerformed(evt);
            }
        });

        lblPasswordLogin.setFont(new java.awt.Font("Rockwell", 0, 22)); // NOI18N
        lblPasswordLogin.setText("Password");

        btnLogin.setBackground(new java.awt.Color(255, 213, 0));
        btnLogin.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(127, 72, 101));
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPasswordLogin.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txtPasswordLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 72, 101)));
        txtPasswordLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPasswordLogin.setName(""); // NOI18N
        txtPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordLoginActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 213, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(144, 70));

        lbLogo1.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo1.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        lbLogo1.setForeground(new java.awt.Color(127, 72, 101));
        lbLogo1.setText("Khake Jao");
        lbLogo1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(lbLogo1))
        );

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsernameLogin)
                            .addComponent(lblPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsernameLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(txtPasswordLogin)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(lbLogo)
                .addGap(28, 28, 28)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameLoginActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameLoginActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
	    try {
		    String username = txtUsernameLogin.getText();
		    String password = String.valueOf(txtPasswordLogin.getPassword());
		    if (!username.isEmpty() && !password.isEmpty()) {
			    if ("Manager".equals(type)) {
				    //logging in as manager

				    Manager m = new Manager();

				    boolean success = m.login(username, password); //search in Managers DB
				    if (success == true) {

					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }

			    } else if (type == "Customer") {
				    User.orderType = "dinein";
				    //logging in as customer
				    Customer c = new Customer();
				    boolean success = c.login(username, password); //search in customers DB
				    if (success == true) {
					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }
			    } else if (type == "Chef") {
				    //logging in as customer
				    Chef chef = new Chef();
				    boolean success = chef.login(username, password); //search in customers DB
				    if (success == true) {
					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }
			    } else if (type == "Waitor") {
				    //logging in as customer
				    User.orderType = "delivery";
				    Waitor waitor = new Waitor();
				    boolean success = waitor.login(username, password); //search in customers DB
				    if (success == true) {
					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }
			    } else if (type == "Owner") {
				    //logging in as customer
				    Owner owner = new Owner();
				    boolean success = owner.login(username, password); //search in customers DB
				    if (success == true) {
					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }
			    }
                              else if (type == "Music") {
				    //logging in as customer
				    MusicBandModel music = new MusicBandModel();
				    boolean success = music.login(username, password); //search in customers DB
				    if (success == true) {
					    homeForm.setVisible(false);
					    JComponent comp = (JComponent) evt.getSource();
					    Window win = SwingUtilities.getWindowAncestor(comp);
					    win.dispose();
				    }
			    }
		    } else {
			    JOptionPane.showMessageDialog(this, "Please fill both TextFields", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		    }
	    } catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordLoginActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbLogo1;
    private javax.swing.JLabel lbUsernameLogin;
    private javax.swing.JLabel lblPasswordLogin;
    private static javax.swing.JPasswordField txtPasswordLogin;
    private static javax.swing.JTextField txtUsernameLogin;
    // End of variables declaration//GEN-END:variables
}
