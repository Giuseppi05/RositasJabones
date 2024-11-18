
package Vistas.Usuario;

import Controlador.RolController;
import Controlador.UsuarioController;
import ModeloDTO.UsuarioDTO;
import Vistas.Login;
import config.UserSession;
import java.awt.Color;
import javax.swing.JOptionPane;
import util.ColorMethods;
import util.ImageLoader;
import util.InactividadUtil;

public class EditUser extends javax.swing.JFrame {
    static UsuarioDTO usuario = UserSession.getUsuario();
    static UsuarioDTO u = new UsuarioDTO();
    static Login login = new Login();
    
    public EditUser(UsuarioDTO u) {
        this.u = u;
        initComponents();
        this.setLocationRelativeTo(null);
        RolController.mostrarRoles(cbxrol);
        
        txtNom.setText(u.getNombre());
        txtmail.setText(u.getCorreo());
        
        RolController.SeleccionarRolEnCbx(cbxrol, u);
        
        ImageLoader.setImageToLabelFromResources(userlbl, "/imagenes/user.png");
        
        InactividadUtil.activarTemporizador(this);
    }
    
    public void limpiar(){
        txtNom.setText(null);
        txtmail.setText(null);
        cbxrol.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        panelRound1 = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        userlbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cbxrol = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SaveButton = new util.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        CancelButton = new util.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        lblErrorCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        txtNom.setBorder(null);
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(226, 57, 173));
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDITAR USUARIO");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(userlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setText("Correo:");

        txtmail.setBorder(null);
        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmailKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel8.setText("Seleccione un rol:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel3.setText("Modifique el usuario:");

        SaveButton.setBackground(new java.awt.Color(227, 34, 167));
        SaveButton.setRoundBottomLeft(15);
        SaveButton.setRoundBottomRight(15);
        SaveButton.setRoundTopLeft(15);
        SaveButton.setRoundTopRight(15);
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveButtonMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GUARDAR CAMBIOS");

        javax.swing.GroupLayout SaveButtonLayout = new javax.swing.GroupLayout(SaveButton);
        SaveButton.setLayout(SaveButtonLayout);
        SaveButtonLayout.setHorizontalGroup(
            SaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SaveButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );
        SaveButtonLayout.setVerticalGroup(
            SaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SaveButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        CancelButton.setBackground(new java.awt.Color(255, 51, 51));
        CancelButton.setRoundBottomLeft(15);
        CancelButton.setRoundBottomRight(15);
        CancelButton.setRoundTopLeft(15);
        CancelButton.setRoundTopRight(15);
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelButtonMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CANCELAR");

        javax.swing.GroupLayout CancelButtonLayout = new javax.swing.GroupLayout(CancelButton);
        CancelButton.setLayout(CancelButtonLayout);
        CancelButtonLayout.setHorizontalGroup(
            CancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        CancelButtonLayout.setVerticalGroup(
            CancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblErrorCorreo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbxrol, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErrorCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtmail, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyReleased
        String txt = txtmail.getText();
        lblErrorCorreo.setText(!UsuarioController.ValidarCorreo(txt) ? "Ingrese un correo válido" : "");
    }//GEN-LAST:event_txtmailKeyReleased

    private void SaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseClicked
        String nombre = txtNom.getText();
        String correo = txtmail.getText();
        String rol = (String) cbxrol.getSelectedItem();

        if (UsuarioController.EditarUsuario(u, nombre, correo, rol, cbxrol)) {
            JOptionPane.showMessageDialog(null, "Registro Actualizado Correctamente");

            Usuarios p = new Usuarios();
            p.setVisible(true);
            limpiar();
            this.dispose();
        }
    }//GEN-LAST:event_SaveButtonMouseClicked

    private void SaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseEntered
        ColorMethods.Entered(SaveButton);
    }//GEN-LAST:event_SaveButtonMouseEntered

    private void SaveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseExited
        ColorMethods.Exited(SaveButton);
    }//GEN-LAST:event_SaveButtonMouseExited

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        Usuarios u = new Usuarios();
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void CancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseEntered
        ColorMethods.Entered(CancelButton, new Color(211,54,30));
    }//GEN-LAST:event_CancelButtonMouseEntered

    private void CancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseExited
        ColorMethods.Exited(CancelButton, new Color(255,51,51));
    }//GEN-LAST:event_CancelButtonMouseExited

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
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (usuario == null) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error en el inicio de sesión",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    login.setVisible(true);
                } else {
                    new EditUser(u).setVisible(true);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound CancelButton;
    private util.PanelRound SaveButton;
    private javax.swing.JComboBox<String> cbxrol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblErrorCorreo;
    private util.PanelRound panelRound1;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtmail;
    private javax.swing.JLabel userlbl;
    // End of variables declaration//GEN-END:variables
}
