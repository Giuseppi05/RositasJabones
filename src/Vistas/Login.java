package Vistas;

import Controlador.LoginController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import util.ColorMethods;

public class Login extends javax.swing.JFrame {
   
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void Login(){
        String email = txtMail.getText().trim();
        String password = txtPass.getText().trim();

        if (LoginController.Login(email, password, this)) {
            txtMail.setText(null);
            txtPass.setText(null);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new util.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LoginButton = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        EditButton = new util.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        ForgotBtn = new util.PanelRound();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 235, 241));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 18, 63));
        jLabel3.setText("Rositas Shop");

        txtMail.setBorder(null);
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        txtMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMailKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 0));
        jLabel6.setText("Correo:");

        txtPass.setBorder(null);
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 0));
        jLabel9.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 0));
        jLabel7.setText("Ingrese sus datos:");

        LoginButton.setBackground(new java.awt.Color(189, 29, 139));
        LoginButton.setRoundBottomLeft(15);
        LoginButton.setRoundBottomRight(15);
        LoginButton.setRoundTopLeft(15);
        LoginButton.setRoundTopRight(15);
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtonMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESAR");

        javax.swing.GroupLayout LoginButtonLayout = new javax.swing.GroupLayout(LoginButton);
        LoginButton.setLayout(LoginButtonLayout);
        LoginButtonLayout.setHorizontalGroup(
            LoginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        LoginButtonLayout.setVerticalGroup(
            LoginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        EditButton.setBackground(new java.awt.Color(255, 96, 205));
        EditButton.setRoundBottomLeft(15);
        EditButton.setRoundBottomRight(15);
        EditButton.setRoundTopLeft(15);
        EditButton.setRoundTopRight(15);
        EditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIMPIAR");

        javax.swing.GroupLayout EditButtonLayout = new javax.swing.GroupLayout(EditButton);
        EditButton.setLayout(EditButtonLayout);
        EditButtonLayout.setHorizontalGroup(
            EditButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        EditButtonLayout.setVerticalGroup(
            EditButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        ForgotBtn.setBackground(new java.awt.Color(255, 255, 255));
        ForgotBtn.setRoundBottomLeft(15);
        ForgotBtn.setRoundBottomRight(15);
        ForgotBtn.setRoundTopLeft(15);
        ForgotBtn.setRoundTopRight(15);
        ForgotBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForgotBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ForgotBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ForgotBtnMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Olvidé mi contraseña");

        javax.swing.GroupLayout ForgotBtnLayout = new javax.swing.GroupLayout(ForgotBtn);
        ForgotBtn.setLayout(ForgotBtnLayout);
        ForgotBtnLayout.setHorizontalGroup(
            ForgotBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ForgotBtnLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        ForgotBtnLayout.setVerticalGroup(
            ForgotBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ForgotBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(ForgotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator2)
                                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ForgotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Login(); 
        }
    }//GEN-LAST:event_txtPassKeyReleased

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        Login();
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void LoginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseEntered
        ColorMethods.Entered(LoginButton);
    }//GEN-LAST:event_LoginButtonMouseEntered

    private void LoginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseExited
        ColorMethods.Exited(LoginButton);
    }//GEN-LAST:event_LoginButtonMouseExited

    private void EditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseEntered
        ColorMethods.Entered(EditButton, new Color(204, 76, 164));
    }//GEN-LAST:event_EditButtonMouseEntered

    private void EditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseExited
        ColorMethods.Exited(EditButton, new Color(255,96,205));
    }//GEN-LAST:event_EditButtonMouseExited

    private void EditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseClicked
        txtMail.setText(null);
        txtPass.setText(null);
    }//GEN-LAST:event_EditButtonMouseClicked

    private void txtMailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           txtPass.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtMailKeyReleased

    private void ForgotBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotBtnMouseClicked
        LoginController.ForgetPassword(this);
    }//GEN-LAST:event_ForgotBtnMouseClicked

    private void ForgotBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotBtnMouseEntered
       ColorMethods.Entered(ForgotBtn, new Color(230,230,230));
    }//GEN-LAST:event_ForgotBtnMouseEntered

    private void ForgotBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotBtnMouseExited
       ColorMethods.Exited(ForgotBtn, new Color(255,255,255));
    }//GEN-LAST:event_ForgotBtnMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound EditButton;
    private util.PanelRound ForgotBtn;
    private util.PanelRound LoginButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private util.PanelRound panelRound1;
    private javax.swing.JTextField txtMail;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
