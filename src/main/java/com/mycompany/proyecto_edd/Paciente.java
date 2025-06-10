/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author Kike DIaz
 */
public class Paciente {
    private String id_paciente;
    private String nombre;
    private String apellido;
    private String alergia;
    private String grupoSanguineo;
    private Boolean seguro;
    private String facultad;

    public String getId_Paciente(){
        return id_paciente;
    }
    public void setId_Paciente(String id_Paciente){
        this.id_paciente =id_Paciente;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    
}