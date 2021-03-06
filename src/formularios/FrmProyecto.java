/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import dao.DaoProyecto;
import javax.swing.JOptionPane;

/**
 *
 * @author Andreita
 */
public class FrmProyecto extends javax.swing.JFrame {
    private boolean esNuevo; 
    private DaoProyecto lista = new DaoProyecto();
    int posActual = 0;


    /**
     * Creates new form FrmProyecto
     */
    public FrmProyecto() {
        initComponents();
        mostrarEnTF(0);
    }
    
    public void setDaoP(DaoProyecto dao){
        lista = dao;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnVolver = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnNuevoT = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardarT = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEliminarT = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnAnteriorT = new javax.swing.JButton();
        LbContador = new javax.swing.JLabel();
        btnSiguienteT = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnActualizarT = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnModificarP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TfNombreProyecto = new javax.swing.JTextField();
        LbIdProyecto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PROYECTO");

        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(32769, 32769));
        jToolBar1.setMinimumSize(new java.awt.Dimension(450, 57));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/anterior (1).png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnVolver);
        jToolBar1.add(jSeparator6);

        btnNuevoT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/agregar-archivo.png"))); // NOI18N
        btnNuevoT.setText("Nuevo");
        btnNuevoT.setFocusable(false);
        btnNuevoT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoT);
        jToolBar1.add(jSeparator1);

        btnGuardarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/disquete.png"))); // NOI18N
        btnGuardarT.setText("Guardar");
        btnGuardarT.setFocusable(false);
        btnGuardarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardarT);
        jToolBar1.add(jSeparator2);

        btnEliminarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/basura.png"))); // NOI18N
        btnEliminarT.setText("Eliminar");
        btnEliminarT.setFocusable(false);
        btnEliminarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminarT);
        jToolBar1.add(jSeparator3);

        btnAnteriorT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/pista-anterior.png"))); // NOI18N
        btnAnteriorT.setText("Anterior");
        btnAnteriorT.setFocusable(false);
        btnAnteriorT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnteriorT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnteriorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnteriorT);

        LbContador.setText("0 de 0");
        jToolBar1.add(LbContador);

        btnSiguienteT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/siguiente-pista.png"))); // NOI18N
        btnSiguienteT.setText("Siguiente");
        btnSiguienteT.setFocusable(false);
        btnSiguienteT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguienteT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSiguienteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSiguienteT);
        jToolBar1.add(jSeparator4);

        btnActualizarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/actualizar.png"))); // NOI18N
        btnActualizarT.setText("Actualizar");
        btnActualizarT.setFocusable(false);
        btnActualizarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizarT);
        jToolBar1.add(jSeparator5);

        btnModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/editar.png"))); // NOI18N
        btnModificarP.setText("Modificar");
        btnModificarP.setFocusable(false);
        btnModificarP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificarP);

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Proyecto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del Proyecto: ");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel2.setText("ID: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LbIdProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTActionPerformed
        // TODO add your handling code here:
        limpiar();
        
        
    }//GEN-LAST:event_btnNuevoTActionPerformed

    private void btnGuardarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTActionPerformed
        // TODO add your handling code here:
        if(TfNombreProyecto.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre", "Proyecto",
                    JOptionPane.WARNING_MESSAGE);
            this.TfNombreProyecto.requestFocus();
            return;
        }
        int b;
        if (esNuevo){            
            if(lista.getListaProyecto().isEmpty()){
                b = lista.agregarProyecto(1, TfNombreProyecto.getText());
            }
            else{
                int IdMayor = lista.buscarIdMayor(); // creo que ya esta
                
                b = lista.agregarProyecto(IdMayor + 1, TfNombreProyecto.getText());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error: Este proyecto ya existe", 
                    "Proyecto", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(b == 1){
            JOptionPane.showMessageDialog(this, "Registro guardado...", "Proyecto",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        this.mostrarEnTF(0);
        limpiar();
    }//GEN-LAST:event_btnGuardarTActionPerformed

    private void btnEliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, 
                "??Realmente desea eliminar el proyecto " + 
                        this.TfNombreProyecto.getText()+ "?","Proyecto", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (resp == 0){
            int b = lista.eliminarProyecto(Integer.parseInt(LbIdProyecto.getText()));
            if(b==1){
                JOptionPane.showMessageDialog(this, "Registro eliminado satisfactoriamente", 
                        "Proyecto", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Error inesperado, verifique y vuelva intentar",
                        "Proyecto", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarTActionPerformed

    private void btnAnteriorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTActionPerformed
        // TODO add your handling code here:
     if (posActual == 0) posActual = lista.getListaProyecto().size();
        posActual--;
        this.mostrarEnTF(posActual);
    }//GEN-LAST:event_btnAnteriorTActionPerformed

    private void btnSiguienteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTActionPerformed
        // TODO add your handling code here:
        posActual++;
        if (posActual == lista.getListaProyecto().size()) posActual = 0;  
        this.mostrarEnTF(posActual);
    }//GEN-LAST:event_btnSiguienteTActionPerformed

    private void btnActualizarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTActionPerformed
        // TODO add your handling code here:
        String msn = lista.actualizarBD();
        JOptionPane.showMessageDialog(this, msn, "Actualizar Base de Datos",
                JOptionPane.INFORMATION_MESSAGE);
        posActual = 0;
        lista = new DaoProyecto();
        mostrarEnTF(posActual);
    }//GEN-LAST:event_btnActualizarTActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
        // TODO add your handling code here:
        FrmModificarP mod = new FrmModificarP();
        mod.setVisible(true);
        int id = Integer.parseInt(LbIdProyecto.getText());
        mod.setDaoP(lista, id);
        this.dispose();
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmInicio ini = new FrmInicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void limpiar(){
        esNuevo = true;
        TfNombreProyecto.setText("");
        LbIdProyecto.setText("");
        TfNombreProyecto.requestFocus();
    }
    private void mostrarEnTF(int fila){
        if(!lista.getListaProyecto().isEmpty() && 
                lista.getListaProyecto().get(fila).getEstado() != 3){
            TfNombreProyecto.setText(lista.getListaProyecto().get(fila).getNombreProyecto());
            LbIdProyecto.setText("" + (lista.getListaProyecto().get(fila).getIdProyecto()));
            
            esNuevo=false;

            int ultReg = lista.getListaProyecto().size();
            LbContador.setText("" + (fila + 1) + " de " + ultReg);
            TfNombreProyecto.requestFocus();
           
        }else{
             limpiar();
             LbContador.setText("" + (0) + " de " + 0);
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
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbContador;
    private javax.swing.JLabel LbIdProyecto;
    private javax.swing.JTextField TfNombreProyecto;
    private javax.swing.JButton btnActualizarT;
    private javax.swing.JButton btnAnteriorT;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnGuardarT;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton btnNuevoT;
    private javax.swing.JButton btnSiguienteT;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
