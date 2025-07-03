package com.mycompany.proyecto_edd;

import java.io.*;
import java.util.ArrayList;

public class Odontologo extends Persona {
    private String idOdontologo;
    private String especialidad;
    private ArrayList<Cita> citas = new ArrayList<>();
    public static ArrayList<Odontologo> listaOdontologos = new ArrayList<>();
    public static final String ARCHIVO = "odontologos.txt";
    public static final String ARCHIVO_ID = "odontologo_id.txt";

    // Ahora: matriz de 15 horas x 6 días (8am a 22pm, lunes a sábado)
    // [hora][día]
    private boolean[][] disponibilidad = new boolean[15][6];

    // Autogeneración de IDs que persisten aunque se cierre el programa
    private static int ultimoID = cargarUltimoID();

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

    // ----- Autogeneración de ID y persistencia -----
    private String generarIdOdontologo() {
        ultimoID++;
        guardarUltimoID();
        return String.format("OD%03d", ultimoID);
    }

    private static int cargarUltimoID() {
        int id = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ID))) {
            String linea = br.readLine();
            if (linea != null) {
                id = Integer.parseInt(linea.trim());
            }
        } catch (IOException | NumberFormatException e) {
            // Archivo no existe, id se queda en 0
        }
        return id;
    }

    private static void guardarUltimoID() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_ID))) {
            pw.println(ultimoID);
        } catch (IOException e) {
            System.out.println("Error guardando último ID odontólogo");
        }
    }

    // ---- Getters ----
    public String getIdOdontologo() { return idOdontologo; }
    public String getEspecialidad() { return especialidad; }
    public ArrayList<Cita> getCitas() { return citas; }
    public boolean[][] getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(int hora, int dia, boolean disponible) {
        disponibilidad[hora][dia] = disponible;
    }

    // ---- Manejo de Odontólogos con archivos ----

    // Cargar todos desde archivo
    public static void cargarOdontologos() {
        listaOdontologos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                if (p.length >= 12) {
                    Odontologo o = new Odontologo(
                        p[0], // id
                        p[2], // nombres
                        p[3], // apellidos
                        p[11], // especialidad
                        p[1], // dni
                        p[4], // sexo
                        p[5], // direccion
                        p[6], // telefono
                        p[7], // fecha_nacimiento
                        p[8], // ciudad
                        p[9], // provincia
                        p[10] // nacionalidad
                    );
                    o.cargarDisponibilidad(); // Carga disponibilidad del archivo propio
                    listaOdontologos.add(o);
                }
            }
        } catch (IOException e) {
            // archivo puede no existir la primera vez
        }
    }

    // Guardar todos en archivo
    public static void guardarOdontologos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Odontologo o : listaOdontologos) {
                pw.println(o.getIdOdontologo() + ";" + o.getDni() + ";" + o.getNombres() + ";" +
                           o.getApellidos() + ";" + o.getSexo() + ";" + o.getDireccion() + ";" +
                           o.getTelefono() + ";" + o.getFecha_nacimiento() + ";" + o.getCiudad() + ";" +
                           o.getProvincia() + ";" + o.getNacionalidad() + ";" + o.getEspecialidad());
                o.guardarDisponibilidad(); // Guarda su disponibilidad cada vez
            }
        } catch (IOException e) {
            System.out.println("Error al guardar odontólogos.");
        }
    }

    // Añadir un odontólogo y guardar
    public static void agregarOdontologoArchivo(Odontologo o) {
        listaOdontologos.add(o);
        guardarOdontologos();
    }

    // Buscar odontólogo por ID
    public static Odontologo buscarOdontologoPorId(String id) {
        for (Odontologo o : listaOdontologos) {
            if (o.getIdOdontologo().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    // Eliminar odontólogo por ID
    public static boolean eliminarOdontologoPorId(String id) {
        Odontologo o = buscarOdontologoPorId(id);
        if (o != null) {
            listaOdontologos.remove(o);
            // Elimina también su archivo de disponibilidad
            File disp = new File(o.getIdOdontologo() + "_disp.txt");
            if (disp.exists()) disp.delete();
            guardarOdontologos();
            return true;
        }
        return false;
    }

    // ---- Disponibilidad ----
    // Guarda la matriz en archivo: una línea por hora, 6 valores por día (1 = disponible, 0 = no)
    public void guardarDisponibilidad() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(idOdontologo + "_disp.txt"))) {
            for (int i = 0; i < 15; i++) { // horas
                for (int j = 0; j < 6; j++) { // días
                    pw.print(disponibilidad[i][j] ? "1" : "0");
                    if (j < 5) pw.print(",");
                }
                pw.println();
            }
        } catch (IOException e) {
            System.out.println("Error guardando disponibilidad de " + idOdontologo);
        }
    }

    // Carga la matriz desde archivo propio (si existe)
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

    // Para JTable: convertir a matriz de Boolean (para checkboxes)
    public Boolean[][] disponibilidadParaTabla() {
        Boolean[][] matriz = new Boolean[15][6];
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 6; j++)
                matriz[i][j] = disponibilidad[i][j];
        return matriz;
    }

    // Para cargar desde JTable: copiar tabla booleana a la matriz
    public void actualizarDisponibilidadDesdeTabla(Boolean[][] tabla) {
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 6; j++)
                disponibilidad[i][j] = tabla[i][j];
    }

    // ---- Citas ----
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
