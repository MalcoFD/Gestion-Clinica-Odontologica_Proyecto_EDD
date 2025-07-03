package com.mycompany.proyecto_edd;

import java.io.*;
import java.util.*;

public class Secretaria extends Persona{
    private String nombreUsuario;
    private String contrasena;
    public static TreeMap<String, Secretaria> mapaSecretarias = new TreeMap<>();


    public Secretaria(String dni, String nombres, String apellidos, String sexo, String direccion,
                      String telefono, String fecha_nacimiento, String ciudad,
                      String provincia, String nacionalidad,
                      String nombreUsuario, String contrasena){
        super(dni, nombres, apellidos, sexo, direccion, telefono,
              fecha_nacimiento, ciudad, provincia, nacionalidad);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    // Método estático para validar usuario y contraseña
    public static boolean validarLogin(String usuario, String contrasena) {
        Secretaria s = mapaSecretarias.get(usuario);
        if (s != null && s.getContrasena().equals(contrasena)) {
            return true;
        }
        return false;
    }


    public static void cargarSecretarias() {
        mapaSecretarias.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("secretarias.txt"))) {
            String linea;
            String dni = "", nombres = "", apellidos = "", sexo = "", direccion = "",
               telefono = "", fecha_nacimiento = "", ciudad = "", provincia = "",
               nacionalidad = "", nombreUsuario = "", password = "";
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("- DNI:")) dni = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Nombres:")) nombres = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Apellidos:")) apellidos = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Sexo:")) sexo = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Dirección:")) direccion = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Teléfono:")) telefono = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Fecha de nacimiento:")) fecha_nacimiento = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Ciudad:")) ciudad = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Provincia:")) provincia = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Nacionalidad:")) nacionalidad = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Nombre de usuario:")) nombreUsuario = linea.substring(linea.indexOf(":") + 1).trim();
                if (linea.startsWith("- Contraseña:")) password = linea.substring(linea.indexOf(":") + 1).trim();

                if (!nombreUsuario.isEmpty() && !password.isEmpty()) {
                    Secretaria s = new Secretaria(
                        dni, nombres, apellidos, sexo, direccion, telefono,
                        fecha_nacimiento, ciudad, provincia, nacionalidad, nombreUsuario, password
                    );
                    mapaSecretarias.put(nombreUsuario, s);

                    // Reinicia para la siguiente secretaria
                    dni = nombres = apellidos = sexo = direccion = telefono = fecha_nacimiento =
                    ciudad = provincia = nacionalidad = nombreUsuario = password = "";
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error leyendo el archivo de secretarias: " + e.getMessage());
        }
    }

   
    // Muestra todas las secretarias cargadas en consola
    public static void mostrarSecretarias() {
        if (mapaSecretarias.isEmpty()) {
            System.out.println("No hay secretarias registradas.");
        } 
        else {
            for (Secretaria s : mapaSecretarias.values()) {
                System.out.println("---- Secretaria ----");
                System.out.println("DNI: " + s.getDni());
                System.out.println("Nombres: " + s.getNombres());
                System.out.println("Apellidos: " + s.getApellidos());
                System.out.println("Sexo: " + s.getSexo());
                System.out.println("Dirección: " + s.getDireccion());
                System.out.println("Teléfono: " + s.getTelefono());
                System.out.println("Fecha de nacimiento: " + s.getFecha_nacimiento());
                System.out.println("Ciudad: " + s.getCiudad());
                System.out.println("Provincia: " + s.getProvincia());
                System.out.println("Nacionalidad: " + s.getNacionalidad());
                System.out.println("Usuario: " + s.getNombreUsuario());
                System.out.println("Contraseña: " + s.getContrasena());
                System.out.println();
            }
        }
    }
}
