/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */
public class Cita {
    private String id;
    private String motivo;
    private Fecha fecha;
    private Hora hora;
    private String estadoCita;
    private String alergias;
    private Paciente paciente;
    private Odontologo odontologo;
    private String observacion;
    

    public Cita() {}
    public Cita(String id, Paciente paciente, Odontologo odontologo,String motivo,Fecha fecha, Hora hora, String alergias, String estadoCita) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
        this.alergias = alergias;
        this.estadoCita = estadoCita;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Fecha getFecha() {
        return fecha;
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    public Hora getHora() {
        return hora;
    }
    public void setHora(Hora hora) {
        this.hora = hora;
    }
    public String getEstadoCita() {
        return estadoCita;
    }
    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
    public String getAlergias() {
        return alergias;
    }
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }
    public void setOdontologo(Odontologo odontologo){
        this.odontologo = odontologo;
    }
    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public String consultarEstado(){
        return "Estado Cita: " + estadoCita;
    }
    public void cancelarCita(){
        if (!this.estadoCita.equals("cancelada")) {
            this.estadoCita = "cancelada";
            System.out.println("Cita cancelada.");
        } else {
            System.out.println("La cita ya está cancelada.");
        }
    }
    public void completarCita(){
        if (!this.estadoCita.equals("completada")) {
            this.estadoCita = "completada";
            System.out.println("Cita completada.");
        } else {
            System.out.println("La cita ya está completada.");
        }
    }
}

