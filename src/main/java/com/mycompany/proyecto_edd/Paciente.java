/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;
import java.util.LinkedList;

/**
 *
 * @author Artentoxx
 */
public class Paciente extends Persona {
    private String id_paciente;
    private String alergia;
    private String grupoSanguineo;
    private Boolean seguro;
    private String facultad;

        public Paciente(String id_paciente, String alergia, String grupoSanguineo, Boolean seguro, String facultad,
                    String dni, String nombres, String apellidos, String sexo, String direccion,
                    String telefono, String fecha_nacimiento, String ciudad,
                    String provincia, String nacionalidad) {
        super(dni, nombres, apellidos, sexo, direccion, telefono, fecha_nacimiento, ciudad, provincia, nacionalidad);
        this.id_paciente = id_paciente;
        this.alergia = alergia;
        this.grupoSanguineo = grupoSanguineo;
        this.seguro = seguro;
        this.facultad = facultad;
    }
        
    public String getId_Paciente(){
        return id_paciente;
    }
    public void setId_Paciente(String id_Paciente){
        this.id_paciente =id_Paciente;
    }
    public String getAlergia(){
        return alergia;
    }
    public void setAlergia(String alergia){
        this.alergia =alergia;
    }
    public String getGrupo_Sanguineo(){
        return grupoSanguineo;
    }
    public void setGrupo_Sanguineo(String grupoSanguineo){
        this.grupoSanguineo =grupoSanguineo;
    }   
    public Boolean getSeguro(){
        return seguro;
    }
    public void setSeguro(Boolean seguro){
        this.seguro =seguro;
    }   
    public String getFacultad(){
        return facultad;
    }
    public void setFacultad(String facultad){
        this.facultad =facultad;
    }
// Agregar paciente
    public static void agregarPaciente(LinkedList<Paciente> lista, Paciente nuevo) {
        lista.add(nuevo);
        System.out.println("Paciente agregado correctamente.");
    }

    // Editar paciente
    public static void editarPaciente(LinkedList<Paciente> lista, String idPaciente, Paciente datosActualizados) {
        for (Paciente p : lista) {
            if (p.getId_Paciente().equals(idPaciente)) {
                p.setAlergia(datosActualizados.getAlergia());
                p.setGrupo_Sanguineo(datosActualizados.getGrupo_Sanguineo());
                p.setSeguro(datosActualizados.getSeguro());
                p.setFacultad(datosActualizados.getFacultad());
                p.setNombres(datosActualizados.getNombres());
                p.setApellidos(datosActualizados.getApellidos());
                p.setTelefono(datosActualizados.getTelefono());
                p.setDireccion(datosActualizados.getDireccion());
                System.out.println("Paciente con ID " + idPaciente + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
    }

    // Eliminar paciente
    public static void eliminarPaciente(LinkedList<Paciente> lista, String idPaciente) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId_Paciente().equals(idPaciente)) {
                lista.remove(i);
                System.out.println("Paciente con ID " + idPaciente + " eliminado correctamente.");
                return;
            }
        }
        System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
    }

}