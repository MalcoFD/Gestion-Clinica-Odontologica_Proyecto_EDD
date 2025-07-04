
package com.mycompany.proyecto_edd.GUI;

import com.mycompany.proyecto_edd.Cita;
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
        // Crear el ActionListener para el botón Buscar
        botonBuscarCita.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            botonBuscarCitaActionPerformed(evt);
        }
    });
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
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btDate1 = new javax.swing.JTextField();
        botonBuscarCita = new javax.swing.JButton();
        btDate2 = new javax.swing.JTextField();
        btDate3 = new javax.swing.JTextField();

        date.setForeground(new java.awt.Color(2, 69, 122));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel1.setText("Cancelar cita");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setText("DNI del paciente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setText("Doctor:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 85, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 122, 133, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setText("Alergias:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 196, 133, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setText("Hora:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 196, 138, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 144, 41));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 122, 138, -1));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel15.setText("Motivo:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 85, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 122, 138, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel16.setText("Fecha:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 196, 133, -1));
        jPanel1.add(btDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 239, 133, -1));

        botonBuscarCita.setBackground(new java.awt.Color(0, 0, 255));
        botonBuscarCita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonBuscarCita.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarCita.setText("Buscar");
        botonBuscarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(btDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 239, 133, -1));
        jPanel1.add(btDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 130, -1));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonBuscarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarCitaActionPerformed
        // Obtener el DNI ingresado por el usuario
        /*
        String dniPaciente = jTextField1.getText().trim();  // Obtener el DNI desde el campo de texto

        // Validar que el DNI no esté vacío
        if (dniPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el DNI del paciente.");
            return;
        }

        // Cargar las citas desde el archivo
        Cita.cargarCitas();  // Usamos el método estático de Cita para cargar las citas
        // Buscar la cita por el DNI ingresado
        Cita cita = Cita.buscarCitaPorDni(dniPaciente);  // Usamos el método estático de Cita para buscar la cita por DNI
        // Si la cita fue encontrada, completar los campos
        if (cita != null) {
            // Completar los campos con los datos de la cita
            jTextField3.setText(cita.getOdontologo().getNombres());  // Completar Doctor
            jTextField2.setText(cita.getMotivo());  // Completar Motivo
            
            // Completar Fecha y Hora
            btDate2.setText(cita.getFecha().fechaAbreviada());  // Completar Fecha
            btDate3.setText(cita.getHora().horaAbreviada());  // Completar Hora
        } else {
            // Si no se encuentra la cita, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "No se encontró una cita con ese DNI.");
        }
*/
    }//GEN-LAST:event_botonBuscarCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarCita;
    private javax.swing.JTextField btDate1;
    private javax.swing.JTextField btDate2;
    private javax.swing.JTextField btDate3;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
