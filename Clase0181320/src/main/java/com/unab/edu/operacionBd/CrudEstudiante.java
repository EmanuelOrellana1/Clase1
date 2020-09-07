/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionBd;
import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.Entidades.Estudiante;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orell
 */
public class CrudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form CrudEstudiante
     */
    public CrudEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTablaEstudiante();
        MostrardatosTabla();
    }

    void MostrarTablaEstudiante() {
        String TITULOS[] = {"ID ESTUDIANTE", "MATRICULA", "ID PERSONA", "NOMBRE PERSONA", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsEstudiante ClaseEstudiante = new ClsEstudiante();
        var Estudiantes = ClaseEstudiante.MostrarEstudiante();
        String filas[] = new String[7];
        for (var IterarDatosEstudiante : Estudiantes) {
            filas[0] = String.valueOf(IterarDatosEstudiante.getIdEsudiante());
            filas[1] = String.valueOf(IterarDatosEstudiante.getMatricula());
            filas[2] = String.valueOf(IterarDatosEstudiante.getIdPersona());
            filas[3] = IterarDatosEstudiante.getNombre();
            filas[4] = IterarDatosEstudiante.getUsu();
            filas[5] = IterarDatosEstudiante.getPass();
            filas[6] = String.valueOf(IterarDatosEstudiante.getNie());
            ModeloTabla.addRow(filas);
        }
        tb_mostarestudiante.setModel(ModeloTabla);

    }

    void MostrardatosTabla() {
        String TITULOS[] = {"ID PERSONA", "NOMBRE PERSONA"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsPersona ClasePersona = new ClsPersona();
        var Personas = ClasePersona.MostrarPersona();
        String filas[] = new String[2];
        for (var IterarDatosPersona : Personas) {
            filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
            filas[1] = IterarDatosPersona.getNombre();
            ModeloTabla.addRow(filas);
        }

        tbTablita.setModel(ModeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMostar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtIdPersona = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtNie = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTablita = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_mostarestudiante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbMostar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID ESTUDIANTE");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("MATRICULA");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("ID PERSONA");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("PASSWORD");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("NIE");

        txtIdEstudiante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtIdPersona.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtNie.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbTablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTablita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTablitaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbTablita);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("SELECIONA LA PERSONA");

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdEstudiante)
                    .addComponent(txtIdPersona)
                    .addComponent(txtMatricula)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUsuario)
                            .addComponent(txtNie)
                            .addComponent(txtPassword)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtNie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addGap(24, 24, 24))
        );

        tbMostar.addTab("DATOS", jPanel1);

        tb_mostarestudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_mostarestudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_mostarestudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_mostarestudiante);

        tbMostar.addTab("VISTA DE DATOS", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMostar, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMostar, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsEstudiante Estudiantes = new ClsEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
        estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        estudiante.setUsu(txtUsuario.getText());
        estudiante.setPass(txtPassword.getText());
        estudiante.setNie(Integer.parseInt(txtNie.getText()));
        Estudiantes.AgregarEstudiante(estudiante);
        MostrarTablaEstudiante();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ClsEstudiante Estudiantes = new ClsEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEsudiante(Integer.parseInt(txtIdEstudiante.getText()));
        Estudiantes.BorrarEstudiante(estudiante);
        MostrarTablaEstudiante();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ClsEstudiante Estudiantes = new ClsEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEsudiante(Integer.parseInt(txtIdEstudiante.getText()));
        estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
        estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        estudiante.setUsu(txtUsuario.getText());
        estudiante.setPass(txtPassword.getText());
        estudiante.setNie(Integer.parseInt(txtNie.getText()));
        Estudiantes.ActualizarEsudiante(estudiante);
        MostrarTablaEstudiante();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tb_mostarestudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_mostarestudianteMouseClicked
        tbMostar.setSelectedIndex(tbMostar.indexOfComponent(jPanel1));

        int fila = tb_mostarestudiante.getSelectedRow();

        String IdEstudiante = String.valueOf(tb_mostarestudiante.getValueAt(fila, 0));
        String Matricula = String.valueOf(tb_mostarestudiante.getValueAt(fila, 1));
        String IdPersona = String.valueOf(tb_mostarestudiante.getValueAt(fila, 2));
        String Usuario = String.valueOf(tb_mostarestudiante.getValueAt(fila, 4));
        String Password = String.valueOf(tb_mostarestudiante.getValueAt(fila, 5));
        String Nie = String.valueOf(tb_mostarestudiante.getValueAt(fila, 6));

        txtIdEstudiante.setText(IdEstudiante);
        txtMatricula.setText(Matricula);
        txtIdPersona.setText(IdPersona);
        txtUsuario.setText(Usuario);
        txtPassword.setText(Password);
        txtNie.setText(Nie);

    }//GEN-LAST:event_tb_mostarestudianteMouseClicked

    private void tbTablitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTablitaMouseClicked
        int fila = tbTablita.getSelectedRow();

        String IdPersona = String.valueOf(tbTablita.getValueAt(fila, 0));
        txtIdPersona.setText(IdPersona);
    }//GEN-LAST:event_tbTablitaMouseClicked

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
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tbMostar;
    private javax.swing.JTable tbTablita;
    private javax.swing.JTable tb_mostarestudiante;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtIdPersona;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNie;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
