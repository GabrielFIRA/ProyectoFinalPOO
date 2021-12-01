package formularios;

import dao.DaoDesempeño;
import dao.DaoProyecto;
import dao.DaoTrabajador;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andreita
 */
public class FrmDesempeño extends javax.swing.JFrame {
    private DaoDesempeño daoD = new DaoDesempeño();
    private DaoTrabajador daoT = new DaoTrabajador();
    private DaoProyecto daoP = new DaoProyecto();
    private int posActualTrab = 0;
    private int posActualProy = 0;
    private boolean esNuevo;
    private String numCedula = "";
    private int IdDesempeño = 0;
    
    /**
     * Creates new form FrmDesempeño
     */
    public FrmDesempeño() {
        initComponents();
        mostrarEnTF(0, 0);
    }
    
    public void setDao(DaoDesempeño daoD, DaoTrabajador daoT, DaoProyecto daoP){
        this.daoD = daoD;
        this.daoT = daoT;
        this.daoP = daoP;
    }
    
    private void mostrarEnTF(int fila1 , int fila2){
        if(!daoT.getListaTrabajador().isEmpty() && !daoP.getListaProyecto().isEmpty()){
            
            numCedula = daoT.getListaTrabajador().get(fila1).getNumCedula();
            int IdProyecto = daoP.getListaProyecto().get(fila2).getIdProyecto();
            
            LbIdProyecto.setText("" + IdProyecto);
            LbNumCedula.setText("" + numCedula);
            
            
            if(daoD.buscarDesempeño(numCedula, IdProyecto) != null ){
                LbIdDesempeño.setText("" + daoD.buscarDesempeño(numCedula, IdProyecto).getIdDesempeño());
                IdDesempeño = Integer.parseInt(LbIdDesempeño.getText());
                TfPuesto.setText(daoD.buscarDesempeño(numCedula, IdProyecto).getPuesto());
                TfCalificacion.setText("" + daoD.buscarDesempeño(numCedula, IdProyecto).getCalificacion());
                TfSalario.setText("" + daoD.buscarDesempeño(numCedula, IdProyecto).getSalario());
                TfFechaI.setText(daoD.buscarDesempeño(numCedula, IdProyecto).getFechaIngreso());
                TfFechaS.setText(daoD.buscarDesempeño(numCedula, IdProyecto).getFechaSalida());
                TfRazon.setText(daoD.buscarDesempeño(numCedula, IdProyecto).getRazonSalida());
            }
            else{
                limpiar();
            }
            
            esNuevo=false;

            int ultReg1 = daoT.getListaTrabajador().size();
            int ultReg2 = daoP.getListaProyecto().size();
            
            LbContadorT.setText("" + (fila1 + 1) + " de " + ultReg1);
            LbContadorP.setText("" + (fila2 + 1) + " de " + ultReg2);
            
            TfPuesto.requestFocus();
        }else{
             limpiar();
        }
    }
    /**
     * Limpia los textFields
     */
    private void limpiar(){
        esNuevo = true;
        LbIdDesempeño.setText("");
        TfPuesto.setText("");
        TfCalificacion.setText("");
        TfSalario.setText("");
        TfRazon.setText("");
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
        btnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnModificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnActualizarBD = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnTrabAnterior = new javax.swing.JButton();
        LbContadorT = new javax.swing.JLabel();
        btnSiguienteTrab = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnProyAnterior = new javax.swing.JButton();
        LbContadorP = new javax.swing.JLabel();
        btnSiguienteProy = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LbIdDesempeño = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        LbIdProyecto = new javax.swing.JLabel();
        LbNumCedula = new javax.swing.JLabel();
        TfPuesto = new javax.swing.JTextField();
        TfSalario = new javax.swing.JTextField();
        CbNotas = new javax.swing.JComboBox<>();
        btnMostarNota = new javax.swing.JButton();
        TfRazon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TfCalificacion = new javax.swing.JTextField();
        TfFechaI = new javax.swing.JTextField();
        TfFechaS = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DESEMPEÑO");

        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/agregar-archivo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);
        jToolBar1.add(jSeparator1);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);
        jToolBar1.add(jSeparator2);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator3);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/disquete.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);
        jToolBar1.add(jSeparator4);

        btnActualizarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/actualizar.png"))); // NOI18N
        btnActualizarBD.setText("Actualizar BD");
        btnActualizarBD.setFocusable(false);
        btnActualizarBD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarBD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnActualizarBD);
        jToolBar1.add(jSeparator5);

        btnTrabAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/pista-anterior.png"))); // NOI18N
        btnTrabAnterior.setText("Trabajador Anterior");
        btnTrabAnterior.setFocusable(false);
        btnTrabAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrabAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrabAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTrabAnterior);

        LbContadorT.setText("0 de 0 ");
        jToolBar1.add(LbContadorT);

        btnSiguienteTrab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/siguiente-pista.png"))); // NOI18N
        btnSiguienteTrab.setText("Siguiente Trabajador");
        btnSiguienteTrab.setFocusable(false);
        btnSiguienteTrab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguienteTrab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSiguienteTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTrabActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSiguienteTrab);
        jToolBar1.add(jSeparator6);

        btnProyAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/anterior (1).png"))); // NOI18N
        btnProyAnterior.setText("Proyecto Anterior");
        btnProyAnterior.setFocusable(false);
        btnProyAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProyAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProyAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProyAnterior);

        LbContadorP.setText("0 de 0");
        jToolBar1.add(LbContadorP);

        btnSiguienteProy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/proximo.png"))); // NOI18N
        btnSiguienteProy.setText("Siguiente Proyecto");
        btnSiguienteProy.setFocusable(false);
        btnSiguienteProy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguienteProy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSiguienteProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteProyActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSiguienteProy);
        jToolBar1.add(jSeparator7);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Desempeño", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel3.setText("Id Desempeño:");

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel4.setText("Id Proyecto:");

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel5.setText("N° de Cédula:");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel6.setText("Puesto:");

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel7.setText("Salario:");

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel8.setText("Fecha de Ingreso:");

        jLabel9.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de Salida:");

        jLabel11.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel11.setText("Razón de Salida:");

        jLabel12.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel12.setText("Nota Disciplinaria:");

        CbNotas.setBackground(new java.awt.Color(255, 153, 102));
        CbNotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nota 1", "Nota 2", "Nota 3" }));

        btnMostarNota.setText("Mostrar Nota");
        btnMostarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarNotaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel13.setText("Calificación: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfFechaI)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TfFechaS, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CbNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMostarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LbIdDesempeño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LbIdProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LbNumCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TfPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))))
                .addGap(439, 439, 439))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbIdDesempeño, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbNumCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TfCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfSalario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TfFechaS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TfRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formulario/iconos/anterior (1).png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmInicio ini = new FrmInicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
        FrmModificarD des = new FrmModificarD(daoD, daoT, daoP, IdDesempeño, numCedula);
        des.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.limpiar();
        
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(TfPuesto.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar el puesto", "Desempeño",
                    JOptionPane.WARNING_MESSAGE);
            this.TfPuesto.requestFocus();
            return;
        }
        
        if(TfSalario.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar el salario", "Desempeño",
                    JOptionPane.WARNING_MESSAGE);
            this.TfSalario.requestFocus();
            return;
        }
        
        if(TfFechaI.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar la fecha de ingreso",
                    "Desempeño", JOptionPane.WARNING_MESSAGE);
            this.TfFechaI.requestFocus();
            return;
        }
        
        int b;
        if(esNuevo){
            if(!daoD.getListaDesempeño().isEmpty()){
                b = daoD.agregarDesempeño(
                        Double.parseDouble(TfCalificacion.getText()),
                        TfFechaI.getText(),
                        TfFechaS.getText(),
                        1,
                        TfPuesto.getText(),
                        TfRazon.getText(),
                        Double.parseDouble(TfSalario.getText()),
                        Integer.parseInt(LbIdProyecto.getText()),
                        LbNumCedula.getText());
            }
            else{
                int mayor = daoD.buscarMayor();
                b = daoD.agregarDesempeño(
                        Double.parseDouble(TfCalificacion.getText()),
                        TfFechaI.getText(),
                        TfFechaS.getText(),
                        mayor + 1,
                        TfPuesto.getText(),
                        TfRazon.getText(),
                        Double.parseDouble(TfSalario.getText()),
                        Integer.parseInt(LbIdProyecto.getText()),
                        LbNumCedula.getText());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error: ya existe este registro",
                    "Desempeño",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(b == 1){
            JOptionPane.showMessageDialog(this, "Registro guardado...", "Desempeño",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        this.mostrarEnTF(0,0);
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnTrabAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabAnteriorActionPerformed
        // TODO add your handling code here:
        if (posActualTrab == 0) posActualTrab = daoT.getListaTrabajador().size();
        posActualTrab--;
        this.mostrarEnTF(posActualTrab, posActualProy);
    }//GEN-LAST:event_btnTrabAnteriorActionPerformed

    private void btnMostarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarNotaActionPerformed
        // TODO add your handling code here:
        String numCedula = daoT.getListaTrabajador().get(posActualTrab).getNumCedula();
        int IdProyecto = daoP.getListaProyecto().get(posActualTrab).getIdProyecto();
        String notas[] = daoD.buscarDesempeño(numCedula, IdProyecto).getNotasDisciplinarias();
        
        if(!notas[0].equals("") && CbNotas.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Nota Disiplinaria:" + "\n" + 
                    notas[0], "Desempeño", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!notas[1].equals("") && CbNotas.getSelectedIndex() == 1){
            JOptionPane.showMessageDialog(this, "Nota Disiplinaria:" + "\n" + 
                    notas[1], "Desempeño", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!notas[2].equals("") && CbNotas.getSelectedIndex() == 2){
            JOptionPane.showMessageDialog(this, "Nota Disiplinaria:" + "\n" + 
                    notas[2], "Desempeño", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay notas disiplinarias", 
                    "Desempeño", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_btnMostarNotaActionPerformed

    private void btnSiguienteTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTrabActionPerformed
        // TODO add your handling code here:
        posActualTrab++;
        if (posActualTrab == daoT.getListaTrabajador().size()) posActualTrab = 0;  
        this.mostrarEnTF(posActualTrab, posActualProy);
    }//GEN-LAST:event_btnSiguienteTrabActionPerformed

    private void btnProyAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyAnteriorActionPerformed
        // TODO add your handling code here:
        if (posActualProy == 0) posActualProy = daoP.getListaProyecto().size();
        posActualProy--;
        this.mostrarEnTF(posActualTrab, posActualProy);
    }//GEN-LAST:event_btnProyAnteriorActionPerformed

    private void btnSiguienteProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteProyActionPerformed
        // TODO add your handling code here:
        posActualProy++;
        if (posActualProy == daoP.getListaProyecto().size()) posActualProy = 0;  
        this.mostrarEnTF(posActualTrab, posActualProy);
    }//GEN-LAST:event_btnSiguienteProyActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, 
                "¿Realmente desea eliminar el Desempeño: " + 
                        this.LbIdDesempeño.getText()+ "?","Desempeño", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (resp == 0){
            int b = daoD.eliminarDesempeño(Integer.parseInt(LbIdDesempeño.getText()));
            if(b == 1){
                JOptionPane.showMessageDialog(this, "Registro eliminado satisfactoriamente", 
                        "Desempeño", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Error inesperado, verifique y vuelva intentar",
                        "Desempeño", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbNotas;
    private javax.swing.JLabel LbContadorP;
    private javax.swing.JLabel LbContadorT;
    private javax.swing.JLabel LbIdDesempeño;
    private javax.swing.JLabel LbIdProyecto;
    private javax.swing.JLabel LbNumCedula;
    private javax.swing.JTextField TfCalificacion;
    private javax.swing.JTextField TfFechaI;
    private javax.swing.JTextField TfFechaS;
    private javax.swing.JTextField TfPuesto;
    private javax.swing.JTextField TfRazon;
    private javax.swing.JTextField TfSalario;
    private javax.swing.JButton btnActualizarBD;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostarNota;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProyAnterior;
    private javax.swing.JButton btnSiguienteProy;
    private javax.swing.JButton btnSiguienteTrab;
    private javax.swing.JButton btnTrabAnterior;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
