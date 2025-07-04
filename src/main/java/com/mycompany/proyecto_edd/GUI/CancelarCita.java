
package com.mycompany.proyecto_edd.GUI;

import com.mycompany.proyecto_edd.Cita;
import com.mycompany.proyecto_edd.HistorialCita;
import com.mycompany.proyecto_edd.Odontologo;
import com.mycompany.proyecto_edd.Paciente;
import com.mycompany.proyecto_edd.PanelConFondo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;




public class CancelarCita extends javax.swing.JPanel {

    
    public CancelarCita() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new PanelConFondo("/FondoPanelCita.png") ;
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btDate1 = new javax.swing.JTextField();
        botonBuscarCita = new javax.swing.JButton();
        btDate2 = new javax.swing.JTextField();
        btDate3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        date.setForeground(new java.awt.Color(2, 69, 122));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 36)); // NOI18N
        jLabel1.setText("Cancelar cita");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel11.setText("DNI del paciente");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel12.setText("Doctor:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel13.setText("Estado:");

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel14.setText("Hora:");

        botonCancelar.setBackground(new java.awt.Color(255, 0, 0));
        botonCancelar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel15.setText("Motivo:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel16.setText("Fecha:");

        botonBuscarCita.setBackground(new java.awt.Color(0, 0, 255));
        botonBuscarCita.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscarCita.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarCita.setText("Buscar");
        botonBuscarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarCitaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel17.setText("Alergias:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(171, 171, 171))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
                            .addComponent(jTextField3)
                            .addComponent(btDate1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonBuscarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(113, 113, 113))
                                            .addComponent(jTextField1)
                                            .addComponent(btDate2))
                                        .addGap(37, 37, 37))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(71, 71, 71)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(113, 113, 113))
                                    .addComponent(btDate3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(72, 72, 72))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136)))))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // Obtener el DNI ingresado por el usuario
        String dniPaciente = jTextField3.getText().trim();  // Obtener el DNI desde el campo de texto

        if (dniPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el DNI del paciente.");
            return;
        }

        // Cargar las citas desde el archivo
        Stack<Cita> listaCitas = Cita.cargarCitas();

        // Buscar la cita por el DNI ingresado
        Cita cita = Cita.buscarCitaPorDni(listaCitas, dniPaciente);
        // Cambiar el estado de la cita a "Cancelada"
        cita.setEstadoCita("Cancelada");
        
        // Actualizar el estado en el JTextField correspondiente
        jTextField4.setText("Cancelada");

        try {
            // Guardar las citas actualizadas en el archivo "citas.txt"
            Cita.guardarCitas(listaCitas);
            
            // Actualizar el historial del paciente con los cambios reflejados
            HistorialCita historial = new HistorialCita();
            historial.generarHistorialDeCitas(dniPaciente, listaCitas);

            JOptionPane.showMessageDialog(this, "La cita ha sido cancelada correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la cita: " + e.getMessage());
        }
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBuscarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarCitaActionPerformed
            // Obtener el DNI ingresado por el usuario
        String dniPaciente = jTextField3.getText().trim();  // Obtener el DNI desde el campo de texto
        if (dniPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el DNI del paciente.");
            return;
        }
        // Cargar las citas desde el archivo
        Stack<Cita> listaCitas = Cita.cargarCitas();

        // Buscar la cita por el DNI ingresado
        Cita cita = Cita.buscarCitaPorDni(listaCitas, dniPaciente);  
        // Si la cita fue encontrada, completar los campos
        if (cita != null) {
            // Completar los campos con los datos de la cita
            jTextField1.setText(cita.getOdontologo().getNombres());
            jTextField2.setText(cita.getMotivo()); 
            Paciente paciente = Paciente.buscarPacientePorDni(dniPaciente); 
            btDate1.setText(paciente.getAlergia()); 
            btDate2.setText(cita.getFecha().fechaAbreviada()); 
            btDate3.setText(cita.getHora().horaAbreviada());
            jTextField4.setText(cita.getEstadoCita());
        } else {
            // Si no se encuentra la cita, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "No se encontró una cita con ese DNI.");
        }
    }//GEN-LAST:event_botonBuscarCitaActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarCita;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField btDate1;
    private javax.swing.JTextField btDate2;
    private javax.swing.JTextField btDate3;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
