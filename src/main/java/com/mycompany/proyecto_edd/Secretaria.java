package com.mycompany.proyecto_edd;

public class Secretaria extends Persona{
    private String idSecretaria;
    private String contrasena;

    public Secretaria(String dni, String nombres, String apellidos, String sexo, String direccion,
                      String telefono, String fecha_nacimiento, String ciudad,
                      String provincia, String nacionalidad,
                      String idSecretaria, String contrasena){
        super(dni, nombres, apellidos, sexo, direccion, telefono,
              fecha_nacimiento, ciudad, provincia, nacionalidad);
        this.idSecretaria = idSecretaria;
        this.contrasena = contrasena;
    }

    public String getIdSecretaria(){
        return idSecretaria;
    }

    public void setIdSecretaria(String idSecretaria){
        this.idSecretaria = idSecretaria;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
}
