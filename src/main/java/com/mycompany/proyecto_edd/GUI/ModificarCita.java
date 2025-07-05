
package com.mycompany.proyecto_edd.GUI;

import com.mycompany.proyecto_edd.Cita;
import com.mycompany.proyecto_edd.Fecha;
import com.mycompany.proyecto_edd.HistorialCita;
import com.mycompany.proyecto_edd.Hora;
import com.mycompany.proyecto_edd.Odontologo;
import com.mycompany.proyecto_edd.Paciente;
import com.mycompany.proyecto_edd.PanelConFondo;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ModificarCita extends javax.swing.JPanel {

    
    public ModificarCita() {
        initComponents();
        cargarOdontologosEnComboBox();
    }
    
    private Map<String, Odontologo> mapas = new HashMap<>();
    
    private void cargarOdontologosEnComboBox() {
       // Cargar todos los odontólogos desde el archivo
        Odontologo.cargarEnArchivo();  // Cargar los odontólogos desde el archivo "odontologos.txt"
        
        // Limpiar el JComboBox para agregar solo los nombres únicos
        doctor.removeAllItems();

        mapas.clear();
        
        // Añadir los nombres únicos al JComboBox
        for (Odontologo odontologo : Odontologo.listaOdontologos){
            String clave = odontologo.getIdOdontologo()+ " - " + odontologo.getNombres();
            
            if(!mapas.containsKey(clave)){
                mapas.put(clave, odontologo);
                doctor.addItem(clave);
            }
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new PanelConFondo("/FondoPanelCita.png") ;
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        doctor = new javax.swing.JComboBox<>();
        hora = new javax.swing.JComboBox<>();
        minutos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dateButton = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        motivoCampo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        dniPaciente = new javax.swing.JButton();

        date.setForeground(new java.awt.Color(2, 69, 122));
        date.setTextRefernce(dateButton);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 500));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 36)); // NOI18N
        jLabel1.setText("Modificar cita:");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel11.setText("DNI del paciente:");

        doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });

        hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        minutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel15.setText("Doctor:");

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel16.setText("Fecha:");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel17.setText("Motivo:");

        dateButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        dateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateButtonActionPerformed(evt);
            }
        });

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel18.setText("Hora:");

        motivoCampo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        motivoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoCampoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(1, 36, 86));
        jButton3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dniPaciente.setBackground(new java.awt.Color(1, 36, 86));
        dniPaciente.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        dniPaciente.setForeground(new java.awt.Color(255, 255, 255));
        dniPaciente.setText("BUSCAR CITA");
        dniPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addGap(289, 289, 289))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(110, 110, 110))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(motivoCampo)
                                .addGap(128, 128, 128))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(250, 250, 250))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(131, 131, 131))
                            .addComponent(doctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(105, 105, 105))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(22, 22, 22)))))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniPaciente)
                    .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hora)
                    .addComponent(minutos)
                    .addComponent(dateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motivoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void dateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        date.showPopup();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void motivoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motivoCampoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Obtenenos el id del paciente
        String id = jTextField2.getText().trim();
        //Obtenenos al nuevo odontologo
        String claveOdontologo = (String) doctor.getSelectedItem();
        Odontologo nuevoOdontologo = mapas.get(claveOdontologo);
        
        if(nuevoOdontologo == null){
            JOptionPane.showMessageDialog(this, "No se encontró el odontologo");
            return;
        }
        
        //Obtenemos la nueva fecha seleccionada
        String fechaSeleccionada = dateButton.getText();
        
        // Dividir el String por el guion "-"
        String[] partesFecha = fechaSeleccionada.split("-");

        // Extraer el año, mes y día
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        // Crear el objeto Fecha con los valores obtenidos
        Fecha nuevaFechaCita = new Fecha(dia, mes, anio);
        // Nueva hora de la cita
        int horaCita = Integer.parseInt((String) hora.getSelectedItem());  // Hora de la cita
        int minutoCita = Integer.parseInt((String) minutos.getSelectedItem());  // Minuto de la cita
        
        Hora nuevaHora = new Hora(horaCita, minutoCita);
        String motivo = motivoCampo.getText();  // Motivo de la cita
        
        
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del paciente.");
            return;
        }
        
        if (motivo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            return;
        }
        
        Stack<Cita> citas = Cita.cargarCitas();
        Cita c = Cita.buscarCitaPorDni(citas, id);
        
        if(c==null){
            JOptionPane.showMessageDialog(this, "Debe buscar una cita pendiente primero.");
            return;
        }
        else{
            
            try {
                Cita.actualizarCita(citas, id, nuevoOdontologo, nuevaFechaCita, nuevaHora);
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
            } 
            catch (IOException ex) {
                
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
    
    }//GEN-LAST:event_doctorActionPerformed

    private void dniPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacienteActionPerformed
        String id = jTextField2.getText().trim();

        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del paciente.");
            return;
        }
        
        Stack<Cita> citas = Cita.cargarCitas();
        Cita c = Cita.buscarCitaPorDni(citas, id);
        if(c != null && c.getEstadoCita().equalsIgnoreCase("Pendiente")){
            
          JOptionPane.showMessageDialog(this, "Cita pendiente encontrada, puede modificar los datos.");  
          
          String claveOdontologo = c.getOdontologo().getIdOdontologo() + " - " + c.getOdontologo().getNombres();
          doctor.setSelectedItem(claveOdontologo);
          dateButton.setText(c.getFecha().getDia()+"-"+c.getFecha().getMes()+"-"+c.getFecha().getAnio());
          hora.setSelectedItem(String.valueOf(c.getHora().getHoras()));
          minutos.setSelectedItem(String.valueOf(c.getHora().getMinutos()));
          motivoCampo.setText(c.getMotivo());
          
        }
        else{
           JOptionPane.showMessageDialog(this, "El paciente no cuenta con citas pendientes.");
            limpiarCampos();
        }
    }//GEN-LAST:event_dniPacienteActionPerformed
    
    private void limpiarCampos(){
        dateButton.setText("");
        motivoCampo.setText("");
        hora.setSelectedIndex(0);
        minutos.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JTextField dateButton;
    private javax.swing.JButton dniPaciente;
    private javax.swing.JComboBox<String> doctor;
    private javax.swing.JComboBox<String> hora;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> minutos;
    private javax.swing.JTextField motivoCampo;
    // End of variables declaration//GEN-END:variables
}
