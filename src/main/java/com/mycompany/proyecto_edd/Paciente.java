/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

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
    // Arreglo estático de pacientes
public static void agregarPaciente(Paciente[] listaPacientes, Paciente nuevo) {
    for (int i = 0; i < listaPacientes.length; i++) {
        if (listaPacientes[i] == null) {
            listaPacientes[i] = nuevo;
            System.out.println("Paciente agregado correctamente en la posición " + i + ".");
            return;
        }
    }
    System.out.println("Error: La lista de pacientes está llena.");
}

    // Editar paciente por ID
public static void editarPaciente(Paciente[] listaPacientes, String idPaciente, Paciente datosActualizados) {
    for (int i = 0; i < listaPacientes.length; i++) {
        if (listaPacientes[i] != null && listaPacientes[i].getId_Paciente().equals(idPaciente)) {
            // Actualizar campos (puedes ajustar según lo necesario)
            listaPacientes[i].setNombres(datosActualizados.getNombres());
            listaPacientes[i].setApellidos(datosActualizados.getApellidos());
            listaPacientes[i].setAlergia(datosActualizados.getAlergia());
            listaPacientes[i].setGrupo_Sanguineo(datosActualizados.getGrupo_Sanguineo());
            listaPacientes[i].setSeguro(datosActualizados.getSeguro());
            listaPacientes[i].setFacultad(datosActualizados.getFacultad());


            System.out.println("Paciente con ID " + idPaciente + " actualizado correctamente.");
            return;
        }
    }
    System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
}


    // Eliminar paciente por ID 
    public static void eliminarPaciente(Paciente[] listaPacientes, String idPaciente) {
        for (int i = 0; i < listaPacientes.length; i++) {
            if (listaPacientes[i] != null && listaPacientes[i].getId_Paciente().equals(idPaciente)) {
                // Desplazar hacia la izquierda
                for (int j = i; j < listaPacientes.length - 1; j++) {
                    listaPacientes[j] = listaPacientes[j + 1];
                }
                listaPacientes[listaPacientes.length - 1] = null;
                System.out.println("Paciente con ID " + idPaciente + " eliminado correctamente.");
                return;
            }
        }
        System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
    }


}