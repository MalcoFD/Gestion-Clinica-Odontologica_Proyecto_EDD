/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */

public class HistorialCita {
    private String nombrePaciente;
    private String nombreOdontologo;
    private String codigoCita;
    private String fechaConsulta;
    private String motivoConsulta;
    private String alergias;

    public HistorialCita() {}
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    public String getNombreOdontologo() {
        return nombreOdontologo;
    }
    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }
    public String getCodigoCita() {
        return codigoCita;
    }
    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }
    public String getFechaConsulta() {
        return fechaConsulta;
    }
    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
    public String getAlergias() {
        return alergias;
    }
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    public void añadirCitaAlHistorial(Cita c){
        this.nombrePaciente = c.getPaciente().getNombre();
        this.nombreOdontologo = c.getOdontologo().getNombre();
        this.codigoCita = c.getId();
        this.fechaConsulta = c.getFecha().toString();
        this.motivoConsulta = c.getMotivo();
        this.alergias = c.getAlergias();
    }
}
