/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;
import java.util.LinkedList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
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
    // Agregar paciente y guardar en archivo
    public static void agregarPaciente(LinkedList<Paciente> lista, Paciente nuevo, String archivo) {
      for (Paciente p : lista) {
          if (p.getId_Paciente().equals(nuevo.getId_Paciente())) {
              System.out.println("Error: Paciente con ID " + nuevo.getId_Paciente() + " ya existe.");
              return;
          }
      }
      lista.add(nuevo);
      guardarEnArchivo(lista, archivo);
      System.out.println("Paciente agregado correctamente.");
  }

  // Editar paciente
  public static void editarPaciente(LinkedList<Paciente> lista, String idPaciente, Paciente datosActualizados, String archivo) {
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
              guardarEnArchivo(lista, archivo);
              System.out.println("Paciente con ID " + idPaciente + " actualizado correctamente.");
              return;
          }
      }
      System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
  }

  // Eliminar paciente
  public static void eliminarPaciente(LinkedList<Paciente> lista, String idPaciente, String archivo) {
      for (int i = 0; i < lista.size(); i++) {
          if (lista.get(i).getId_Paciente().equals(idPaciente)) {
              lista.remove(i);
              guardarEnArchivo(lista, archivo);
              System.out.println("Paciente con ID " + idPaciente + " eliminado correctamente.");
              return;
          }
      }
      System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
  }

  // Guardar en archivo (ahora recibe la ruta como parámetro)
  private static void guardarEnArchivo(LinkedList<Paciente> lista, String archivo) {
    // Nombres de las columnas
    String[] columnas = {
        "ID", "Alergia", "Grupo", "Seguro", "Facultad",
        "DNI", "Nombres", "Apellidos", "Sexo", "Dirección",
        "Teléfono", "Nacimiento", "Ciudad", "Provincia", "Nacionalidad"
    };
    // Extraer datos de pacientes como matriz de Strings
    List<String[]> filas = new ArrayList<>();
    for (Paciente p : lista) {
        String[] fila = {
            p.getId_Paciente(), p.getAlergia(), p.getGrupo_Sanguineo(),
            String.valueOf(p.getSeguro()), p.getFacultad(),
            p.getDni(), p.getNombres(), p.getApellidos(), p.getSexo(),
            p.getDireccion(), p.getTelefono(), p.getFecha_nacimiento(),
            p.getCiudad(), p.getProvincia(), p.getNacionalidad()
        };
        filas.add(fila);
    }
    // Calcular el ancho máximo por columna
    int[] anchos = new int[columnas.length];
    for (int i = 0; i < columnas.length; i++) {
        anchos[i] = columnas[i].length(); // empieza con el largo del encabezado
        for (String[] fila : filas) {
            if (fila[i].length() > anchos[i]) {
                anchos[i] = fila[i].length();
            }
        }
    }
    // Escribir al archivo con formato de tabla
    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {

        // Línea de cabecera
        for (int i = 0; i < columnas.length; i++) {
            writer.printf("%-" + anchos[i] + "s", columnas[i]);
            if (i < columnas.length - 1) writer.print(" | ");
        }
        writer.println();

        // Línea divisoria
        for (int i = 0; i < columnas.length; i++) {
            writer.print("-".repeat(anchos[i]));
            if (i < columnas.length - 1) writer.print("-+-");
        }
        writer.println();

        // Datos
        for (String[] fila : filas) {
            for (int i = 0; i < fila.length; i++) {
                writer.printf("%-" + anchos[i] + "s", fila[i]);
                if (i < fila.length - 1) writer.print(" | ");
            }
            writer.println();
        }

    } catch (IOException e) {
        System.out.println("Error al guardar pacientes: " + e.getMessage());
    }
}
  // Cargar desde archivo (también parametrizable)
    public static LinkedList<Paciente> cargarDesdeArchivo(String archivo) {
        LinkedList<Paciente> lista = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int lineaActual = 0;
            while ((linea = reader.readLine()) != null) {
                lineaActual++;
                // Saltar la primera (cabecera) y segunda línea (divisor)
                if (lineaActual <= 2) continue;
                // Separar los datos por el separador " | "
                String[] partes = linea.split(" \\| ");
                // Asegurarse de que tenga 15 campos
                if (partes.length != 15) {
                    System.out.println("Línea inválida (omitida): " + linea);
                    continue;
                }
                // Eliminar posibles espacios al final
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].trim();
                }
                // Crear paciente
                Paciente p = new Paciente(
                    partes[0], partes[1], partes[2], Boolean.parseBoolean(partes[3]), partes[4],
                    partes[5], partes[6], partes[7], partes[8], partes[9],
                    partes[10], partes[11], partes[12], partes[13], partes[14]
                );
                lista.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return lista;
    }

}