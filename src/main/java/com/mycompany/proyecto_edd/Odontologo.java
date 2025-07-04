package com.mycompany.proyecto_edd;

import java.io.*;
import java.util.ArrayList;

public class Odontologo extends Persona {
    private String idOdontologo;
    private String especialidad;
    private ArrayList<Cita> citas = new ArrayList<>();
    public static ArrayList<Odontologo> listaOdontologos = new ArrayList<>();

    // Matriz de disponibilidad [hora][día]
    private boolean[][] disponibilidad = new boolean[15][6];

    // ==== CARGAR AL INICIO ====
    static {
        listaOdontologos = cargarEnArchivo();
    }

    // Constructor (nuevo odontólogo)
    public Odontologo(String nombres, String apellidos, String especialidad, String dni, String sexo,
                      String direccion, String telefono, String fecha_nacimiento, String ciudad,
                      String provincia, String nacionalidad) {
        super(dni, nombres, apellidos, sexo, direccion, telefono, fecha_nacimiento, ciudad, provincia, nacionalidad);
        this.idOdontologo = generarIdOdontologo();
        this.especialidad = especialidad;
    }

    // Constructor usado al cargar desde archivo (con ID existente)
    public Odontologo(String idOdontologo, String nombres, String apellidos, String especialidad, String dni, String sexo,
                      String direccion, String telefono, String fecha_nacimiento, String ciudad,
                      String provincia, String nacionalidad) {
        super(dni, nombres, apellidos, sexo, direccion, telefono, fecha_nacimiento, ciudad, provincia, nacionalidad);
        this.idOdontologo = idOdontologo;
        this.especialidad = especialidad;
    }

    // ---- Lógica de autogeneración de ID ----
    private String generarIdOdontologo() {
        int maxId = 0;
        for (Odontologo o : listaOdontologos) {
            String num = o.getIdOdontologo().replaceAll("\\D+", "");
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                if (n > maxId) maxId = n;
            }
        }
        int nextId = maxId + 1;
        return String.format("OD%03d", nextId);
    }

    // ---- Getters ----
    public String getIdOdontologo() { return idOdontologo; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad;}
    public ArrayList<Cita> getCitas() { return citas; }
    public boolean[][] getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(int hora, int dia, boolean disponible) {
        disponibilidad[hora][dia] = disponible;
    }

    // ==== GUARDAR EN TABLA BONITA ====
    public static void guardarEnArchivo(ArrayList<Odontologo> lista) {
        String[] columnas = {
            "ID", "DNI", "Nombres", "Apellidos", "Sexo", "Direccion", "Telefono",
            "Nacimiento", "Ciudad", "Provincia", "Nacionalidad", "Especialidad"
        };

        ArrayList<String[]> filas = new ArrayList<>();
        for (Odontologo o : lista) {
            String[] fila = {
                o.getIdOdontologo(), o.getDni(), o.getNombres(), o.getApellidos(),
                o.getSexo(), o.getDireccion(), o.getTelefono(), o.getFecha_nacimiento(),
                o.getCiudad(), o.getProvincia(), o.getNacionalidad(), o.getEspecialidad()
            };
            filas.add(fila);
        }

        int[] anchos = new int[columnas.length];
        for (int i = 0; i < columnas.length; i++) {
            anchos[i] = columnas[i].length();
            for (String[] fila : filas) {
                if (fila[i].length() > anchos[i]) {
                    anchos[i] = fila[i].length();
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("odontologos.txt"))) {
            // Encabezado
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
            // Filas
            for (String[] fila : filas) {
                for (int i = 0; i < fila.length; i++) {
                    writer.printf("%-" + anchos[i] + "s", fila[i]);
                    if (i < fila.length - 1) writer.print(" | ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar odontólogos: " + e.getMessage());
        }
    }

    // ==== CARGAR DESDE TABLA BONITA ====
    public static ArrayList<Odontologo> cargarEnArchivo() {
        ArrayList<Odontologo> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("odontologos.txt"))) {
            String linea;
            int lineaActual = 0;
            while ((linea = reader.readLine()) != null) {
                lineaActual++;
                if (lineaActual <= 2) continue; // Saltar encabezado y divisor

                String[] partes = linea.split(" \\| ");
                if (partes.length != 12) {
                    System.out.println("Línea inválida (omitida): " + linea);
                    continue;
                }
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].trim();
                }

                Odontologo o = new Odontologo(
                    partes[0], // id
                    partes[2], // nombres
                    partes[3], // apellidos
                    partes[11], // especialidad
                    partes[1], // dni
                    partes[4], // sexo
                    partes[5], // direccion
                    partes[6], // telefono
                    partes[7], // fecha_nacimiento
                    partes[8], // ciudad
                    partes[9], // provincia
                    partes[10] // nacionalidad
                );
                lista.add(o);
            }
        } catch (IOException e) {
            // Si el archivo no existe, retorna lista vacía
        }
        return lista;
    }

    // ==== Añadir, buscar y eliminar ====

    public static void agregarOdontologoArchivo(Odontologo o) {
        listaOdontologos.add(o);
        guardarEnArchivo(listaOdontologos);
    }

    public static Odontologo buscarOdontologoPorId(String id) {
        for (Odontologo o : listaOdontologos) {
            if (o.getIdOdontologo().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    public static boolean eliminarOdontologoPorId(String id) {
        Odontologo o = buscarOdontologoPorId(id);
        if (o != null) {
            listaOdontologos.remove(o);
            // Elimina también su archivo de disponibilidad
            File disp = new File(o.getIdOdontologo() + "_disp.txt");
            if (disp.exists()) disp.delete();
            guardarEnArchivo(listaOdontologos);
            return true;
        }
        return false;
    }

    public static Odontologo buscarOdontologoPorNombre(String nombre) {
        for (Odontologo o : listaOdontologos) {
            if (o.getNombres().equalsIgnoreCase(nombre)) {
                return o;
            }
        }
        return null;
    }

    // ==== Disponibilidad ====
    public void guardarDisponibilidad() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(idOdontologo + "_disp.txt"))) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 6; j++) {
                    pw.print(disponibilidad[i][j] ? "1" : "0");
                    if (j < 5) pw.print(",");
                }
                pw.println();
            }
        } catch (IOException e) {
            System.out.println("Error guardando disponibilidad de " + idOdontologo);
        }
    }

    public void cargarDisponibilidad() {
        try (BufferedReader br = new BufferedReader(new FileReader(idOdontologo + "_disp.txt"))) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null && i < 15) {
                String[] tokens = linea.split(",");
                for (int j = 0; j < tokens.length && j < 6; j++) {
                    disponibilidad[i][j] = tokens[j].equals("1");
                }
                i++;
            }
        } catch (IOException e) {
            // Si no existe, se deja todo en falso (libre)
        }
    }

    public Boolean[][] disponibilidadParaTabla() {
        Boolean[][] matriz = new Boolean[15][6];
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 6; j++)
                matriz[i][j] = disponibilidad[i][j];
        return matriz;
    }

    public void actualizarDisponibilidadDesdeTabla(Boolean[][] tabla) {
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 6; j++)
                disponibilidad[i][j] = tabla[i][j];
    }

    // ==== Citas ====
    public void agregarCita(Cita c) {
        if (!citas.contains(c)) {
            citas.add(c);
        }
    }

    public ArrayList<Cita> getCitasOdontologo() {
        return citas;
    }
    
    // ---- Para JTable (mostrar resumen en tabla) ----
    public static Object[][] odontologosParaTabla() {
        Object[][] data = new Object[listaOdontologos.size()][5];
        for (int i = 0; i < listaOdontologos.size(); i++) {
            Odontologo o = listaOdontologos.get(i);
            data[i][0] = o.getIdOdontologo();
            data[i][1] = o.getNombres();
            data[i][2] = o.getApellidos();
            data[i][3] = o.getEspecialidad();
            data[i][4] = o.getTelefono();
        }
        return data;
    }
}
