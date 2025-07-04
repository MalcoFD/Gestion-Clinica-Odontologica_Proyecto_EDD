/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */
import java.io.*;
import java.util.Stack;

public class Cita {
    private String id;
    private String motivo;
    private Fecha fecha;
    private Hora hora;
    private String estadoCita;
    private Paciente paciente;
    private Odontologo odontologo;

    // Stack estático que almacena todas las citas
    public static Stack<Cita> listaCitas = new Stack<>();
    public static final String ARCHIVO = "citas.txt";
    private static int contadorId = 1;  // Contador estático para generar IDs únicos

    public Cita() {}

    public Cita(String id, Paciente paciente, Odontologo odontologo, String motivo, Fecha fecha, Hora hora, String estadoCita) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCita = estadoCita;
    }

    // Métodos getter y setter para los atributos
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
    
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Odontologo getOdontologo() {
        return odontologo;
    }
    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    // Métodos de operación

    // Generar ID automático para la cita
    private static String generarIdCita() {
        return String.valueOf(contadorId++);
    }

    // Añadir una nueva cita
    public static void añadirCita(Paciente paciente, Odontologo odontologo, String motivo, Fecha fecha, Hora hora) throws IOException {
        String idCita = generarIdCita();  // Generar ID único
        String estado = "Pendiente";  // Estado por defecto
        Cita nuevaCita = new Cita(idCita, paciente, odontologo, motivo, fecha, hora, estado);
        listaCitas.push(nuevaCita);  // Añadir la cita al Stack
        guardarCitas();  // Guardar las citas en el archivo

        // Generar el historial de citas para el paciente
        HistorialCita historial = new HistorialCita();
        historial.generarHistorialDeCitas(paciente.getDni(), listaCitas);
        System.out.println("Cita añadida correctamente.");
    }

    // Buscar una cita por el DNI del paciente
    public static Cita buscarCitaPorDni(String dniPaciente) {
        for (Cita cita : listaCitas) {
            if (cita.getPaciente().getDni().equals(dniPaciente)) {
                return cita;
            }
        }
        return null;
    }

    // Actualizar una cita (fecha, hora, estado, etc.)
    public static void actualizarCita(String dniPaciente, Fecha nuevaFecha, Hora nuevaHora) throws IOException {
        boolean citaActualizada = false;

        // Buscar la cita correspondiente al paciente
        for (Cita cita : listaCitas) {
            if (cita.getPaciente().getDni().equals(dniPaciente)) {
                // Actualizar solo la fecha y la hora
                cita.setFecha(nuevaFecha);
                cita.setHora(nuevaHora);

                // Mantenemos el estado como "Pendiente"
                cita.setEstadoCita("Pendiente");

                citaActualizada = true;
                System.out.println("Cita actualizada correctamente");
                break;  // Salir del ciclo una vez que se actualizó la cita
            }
        }

        // Si la cita fue actualizada, guardar las citas en el archivo
        if (citaActualizada) {
            guardarCitas();  // Guardar las citas actualizadas en el archivo

            // Actualizar el historial del paciente con los cambios reflejados
            Paciente paciente = listaCitas.peek().getPaciente();  // Obtener el paciente de la cita actualizada
            HistorialCita historial = new HistorialCita();
            historial.generarHistorialDeCitas(paciente.getDni(), listaCitas);
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }

    // Cancelar una cita
    public static void cancelarCita(String dniPaciente) throws IOException {
        Cita citaACancelar = buscarCitaPorDni(dniPaciente);

        if (citaACancelar != null) {
            // Cambiar el estado de la cita a "Cancelada"
            citaACancelar.setEstadoCita("Cancelada");

            // Escribir los cambios en el archivo "Citas.txt"
            guardarCitas();  // Guardar las citas actualizadas

            // Actualizar el archivo del historial del paciente
            HistorialCita historial = new HistorialCita();
            historial.generarHistorialDeCitas(dniPaciente, listaCitas);

            System.out.println("Cita con DNI " + dniPaciente + " cancelada correctamente.");
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }

    // Guardar todas las citas en el archivo
    private static void guardarCitas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Cita cita : listaCitas) {
                pw.println(cita.getId() + "-" +
                        cita.getPaciente().getDni() + "-" +
                        cita.getPaciente().getNombres() + "-" +
                        cita.getOdontologo().getNombres() + "-" +
                        cita.getMotivo() + "-" +
                        cita.getFecha().fechaAbreviada() + "-" +
                        cita.getHora().horaAbreviada() + "-" +
                        cita.getEstadoCita());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las citas: " + e.getMessage());
        }
    }

    // Cargar todas las citas desde el archivo
    public static void cargarCitas() {
        listaCitas.clear();  // Limpiar el Stack antes de cargar las citas
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("-");
                if (datos.length == 9) {
                    String idCita = datos[0];
                    String dniPaciente = datos[1];
                    String nombrePaciente = datos[2];
                    String nombreOdontologo = datos[3];
                    String motivo = datos[4];
                    String fechaAbreviada = datos[5];
                    String horaAbreviada = datos[6];
                    String alergias = datos[7];
                    String estado = datos[8];

                    // Buscar el paciente y odontólogo correspondientes
                    Paciente paciente = buscarPacientePorDni(dniPaciente);
                    Odontologo odontologo = buscarOdontologoPorNombre(nombreOdontologo);

                    if (paciente != null && odontologo != null) {
                        String[] partesFecha = fechaAbreviada.split("/");
                        int dia = Integer.parseInt(partesFecha[0]);
                        int mes = Integer.parseInt(partesFecha[1]);
                        int anio = Integer.parseInt(partesFecha[2]);
                        Fecha fecha = new Fecha(dia, mes, anio);

                        String[] partesHora = horaAbreviada.split(":");
                        int horas = Integer.parseInt(partesHora[0]);
                        int minutos = Integer.parseInt(partesHora[1]);
                        Hora hora = new Hora(horas, minutos);

                        Cita cita = new Cita(idCita, paciente, odontologo, motivo, fecha, hora, estado);
                        listaCitas.push(cita);  // Usar Stack para agregar la cita
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las citas: " + e.getMessage());
        }
    }

    // Métodos para buscar paciente y odontólogo por DNI y nombre respectivamente
    private static Paciente buscarPacientePorDni(String dni) {
        return Paciente.buscarPacientePorDni(dni); // Método de la clase Paciente
    }

    private static Odontologo buscarOdontologoPorNombre(String nombre) {
        return Odontologo.buscarOdontologoPorNombre(nombre); // Método de la clase Odontologo
    }
}

