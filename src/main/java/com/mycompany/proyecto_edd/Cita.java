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

    public static final String ARCHIVO = "citas.txt";

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

    // Métodos getter y setter
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

    // Añadir una nueva cita
    public static void añadirCita(Stack<Cita> citas, Cita citanueva) throws IOException {
        boolean citaExistente = false;
        HistorialCita historial = new HistorialCita();
        // Verificar si el paciente ya tiene una cita pendiente
        for (Cita c : citas) {
            if (c.getPaciente().getDni().equals(citanueva.getPaciente().getDni()) && c.getEstadoCita().equals("Pendiente")) {
                // Si ya tiene una cita pendiente, cambiar el estado de la cita a "Terminado"
                c.setEstadoCita("Terminado");
                citaExistente = true;
                
                System.out.println("Cita anterior marcada como 'Terminado'");
                break;
            }
        }
        
        citas.push(citanueva);
        System.out.println("Cita agregada correctamente.");

        // Guardar las citas en el archivo
        guardarCitas(citas);
        historial.actualizarHistorialDeCitas(citanueva.getPaciente().getDni(), citas);
        System.out.println("Cita añadida correctamente.");
    }

    // Buscar una cita por el DNI del paciente
    public static Cita buscarCitaPorDni(Stack<Cita> citas, String dniPaciente) {
        // Recorrer la pila de citas desde la más reciente
        for (int i = citas.size() - 1; i >= 0; i--) {
            Cita cita = citas.get(i); // Obtener la cita en la posición i (de atrás hacia adelante)
            if (cita.getPaciente().getDni().equals(dniPaciente) && cita.getEstadoCita().equals("Pendiente")) {
                return cita;  // Devolver la cita pendiente más reciente
            }
        }
        return null;  // No se encontró ninguna cita pendiente para ese paciente
    }

    // Actualizar una cita (fecha, hora, estado, etc.)
    public static void actualizarCita(Stack<Cita> citas, String dniPaciente, Odontologo nuevoOdontologo, Fecha nuevaFecha, Hora nuevaHora) throws IOException {
        boolean citaActualizada = false;
        Cita citaActualizarRef = null;

        // Buscar la cita correspondiente al paciente más reciente
        for (Cita cita : citas) {
            if (cita.getPaciente().getDni().equals(dniPaciente) && cita.getEstadoCita().equalsIgnoreCase("Pendiente")) {
                // Actualizar solo la fecha y la hora
                cita.setFecha(nuevaFecha);
                cita.setHora(nuevaHora);
                cita.setOdontologo(nuevoOdontologo);

                // Mantenemos el estado como "Pendiente"
                cita.setEstadoCita("Pendiente");

                citaActualizada = true;
                citaActualizarRef = cita;
                System.out.println("Cita actualizada correctamente");
                break;  // Salir del ciclo una vez que se actualizó la cita
            }
        }

        // Si la cita fue actualizada, guardar las citas en el archivo
        if (citaActualizada && citaActualizarRef != null) {
            guardarCitas(citas);  // Guardar las citas actualizadas en el archivo

            // Actualizar el historial del paciente con los cambios reflejados
            HistorialCita historial = new HistorialCita();
            historial.actualizarHistorialDeCitas(citaActualizarRef.getPaciente().getDni(), citas);
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }

    // Cancelar una cita
    public static void cancelarCita(Stack<Cita> citas, String dniPaciente) throws IOException {
        Cita citaACancelar = buscarCitaPorDni(citas, dniPaciente);

        if (citaACancelar != null) {
            // Cambiar el estado de la cita a "Cancelada"
            citaACancelar.setEstadoCita("Cancelada");

            // Escribir los cambios en el archivo "Citas.txt"
            guardarCitas(citas);  // Guardar las citas actualizadas

            // Actualizar el archivo del historial del paciente
            HistorialCita historial = new HistorialCita();
            historial.actualizarHistorialDeCitas(dniPaciente, citas);

            System.out.println("Cita con DNI " + dniPaciente + " cancelada correctamente.");
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }

    // Guardar todas las citas en el archivo
    public static void guardarCitas(Stack<Cita> listaCitas) {
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

    // Cargar todas las citas desde el archivo y devolver la pila de citas
    public static Stack<Cita> cargarCitas() {
        Stack<Cita> listaCitas = new Stack<>();  // Usamos un Stack en lugar de LinkedList
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("-");
                if (datos.length == 8) {
                    String idCita = datos[0];
                    String dniPaciente = datos[1];
                    String nombrePaciente = datos[2];
                    String nombreOdontologo = datos[3];
                    String motivo = datos[4];
                    String fechaAbreviada = datos[5];
                    String horaAbreviada = datos[6];
                    String estado = datos[7];

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
        return listaCitas;  // Retorna la pila cargada
    }

    // Métodos para buscar paciente y odontólogo por DNI y nombre respectivamente
    private static Paciente buscarPacientePorDni(String dni) {
        return Paciente.buscarPacientePorDni(dni); // Método de la clase Paciente
    }

    private static Odontologo buscarOdontologoPorNombre(String nombre) {
        return Odontologo.buscarOdontologoPorNombre(nombre); // Método de la clase Odontologo
    }
}


