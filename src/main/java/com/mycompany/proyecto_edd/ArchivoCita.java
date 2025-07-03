/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

public class ArchivoCita {

    // Contador estático para generar ID único de citas
    private static int contadorId = 1;

    // Método para generar ID único
    private String generarIdCita() {
        return String.valueOf(contadorId++);
    }
    public void añadirCita(Paciente paciente, Odontologo odontologo, String motivo,
                           Fecha fecha, Hora hora, String alergias, Stack<Cita> citas) throws IOException {
        String idCita = generarIdCita();
        String estado = "Pendiente";
        Cita nuevaCita = new Cita(idCita, paciente, odontologo, motivo, fecha, hora, alergias, estado);
        citas.push(nuevaCita);
        escribir(citas);
        System.out.println("Cita añadida correctamente.");
        HistorialCita historial = new HistorialCita();
        historial.generarHistorialDeCitas(paciente.getDni(), citas);
    }


    public Cita buscarCitaPorDni(String dniPaciente, Stack<Cita> citas) {
        for(Cita cita : citas) {
            if(cita.getPaciente().getDni().equals(dniPaciente)) {
                return cita;
            }
        }
        return null; // Si no se encuentra la cita
    }
    public void actualizarCita(String dniPaciente, Fecha nuevaFecha, Hora nuevaHora, Stack<Cita> citas) throws IOException {
        boolean citaActualizada = false;

        // Buscar la cita correspondiente al paciente
        for (Cita cita : citas) {
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

        // Si la cita fue actualizada, escribir las citas al archivo
        if (citaActualizada) {
            // Actualizar el archivo "Citas.txt" con las citas modificadas
            escribir(citas);

            // También actualizamos el historial del paciente con los cambios reflejados
            Paciente paciente = citas.peek().getPaciente();  // Obtenemos el paciente de la cita actualizada
            HistorialCita historial = new HistorialCita();
            historial.generarHistorialDeCitas(paciente.getDni(), citas);
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }
    public void cancelarCita(String dniPaciente, Stack<Cita> citas) throws IOException {
        // Buscar la última cita del paciente (la más reciente)
        Cita citaACancelar = buscarCitaPorDni(dniPaciente, citas);

        if (citaACancelar != null) {
            // Cambiar el estado de la cita a "Cancelada"
            citaACancelar.setEstadoCita("Cancelada");

            // Escribir los cambios en el archivo "Citas.txt"
            escribir(citas);

            // Actualizar el archivo del historial del paciente
            HistorialCita historial = new HistorialCita();
            historial.generarHistorialDeCitas(dniPaciente, citas);

            System.out.println("Cita con DNI " + dniPaciente + " cancelada correctamente.");
        } else {
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }
    public void escribir(Stack<Cita> citas) throws IOException {
        try (FileWriter fw = new FileWriter("Citas.txt");
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter salida = new PrintWriter(bw)) {

            for (Cita c : citas) {
                salida.println(c.getId() + "-"
                        + c.getPaciente().getDni() + "-"
                        + c.getPaciente().getNombres() + "-"
                        + c.getOdontologo().getNombres() + "-"
                        + c.getMotivo() + "-"
                        + c.getFecha().fechaAbreviada() + "-"
                        + c.getHora().horaAbreviada() + "-"
                        + c.getAlergias() + "-"
                        + c.getEstadoCita());
            }
        }
    }

    public Stack<Cita> leer(LinkedList<Paciente> pacientes, ArrayList<Odontologo> odontologos) throws IOException {
        Stack<Cita> citas = new Stack<>();
        try (FileReader fr = new FileReader("Citas.txt");
             BufferedReader entrada = new BufferedReader(fr)) {

            String s;
            while ((s = entrada.readLine()) != null) {
                String[] informacion = s.split("-");
                if (informacion.length == 9) {  // Verificación de la longitud
                    String idCita = informacion[0];
                    String dniPaciente = informacion[1];
                    String nombrePaciente = informacion[2];
                    String nombreOdontologo = informacion[3];
                    String motivo = informacion[4];
                    String fechaAbreviada = informacion[5];
                    String horaAbreviada = informacion[6];
                    String alergias = informacion[7];
                    String estado = informacion[8];

                    Paciente paciente = buscarPacientePorDni(dniPaciente, pacientes);
                    Odontologo odontologo = buscarOdontologoPorNombre(nombreOdontologo, odontologos);

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

                        Cita cita = new Cita(idCita, paciente, odontologo, motivo, fecha, hora, alergias, estado);
                        citas.push(cita);
                    }
                }
            }
        }
        return citas;
    }

    private Paciente buscarPacientePorDni(String dni, LinkedList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombres().equals(dni)) {
                return paciente;
            }
        }
        return null;
    }

    private Odontologo buscarOdontologoPorNombre(String nombre, ArrayList<Odontologo> odontologos) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNombres().equals(nombre)) {
                return odontologo;
            }
        }
        return null;
    }
}
