/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;
import java.util.ArrayList;
/**
 *
 * @author FAS
 */
public class Odontologo {
    private String idOdontologo;
    private String nombre;
    private String apellido;
    private String especialidad;
    private ArrayList<Cita> citas = new ArrayList<>();

    public Odontologo(String idOdontologo, String nombre, String apellido, String especialidad) {
        this.idOdontologo = idOdontologo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getIdOdontologo() { return idOdontologo; }
    public String getEspecialidad() { return especialidad; }

    public void agregarCita(Cita c) {
        if (!citas.contains(c)) {
            citas.add(c);
        }
    }

    public void mostrarCitas() {
        for (Cita c : citas) {
            System.out.println("Cita: " + c.getMotivo() + " - " + c.getFecha());
        }
    }

    public void observacionCita(Cita cita, String observacion) {
        cita.setObservacion(observacion);
    }
}

