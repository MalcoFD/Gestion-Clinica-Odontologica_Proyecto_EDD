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

    public void escribir(Stack<Cita> Citas) throws IOException {
        try (FileWriter fw = new FileWriter("Citas.txt");
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter salida = new PrintWriter(bw)) {

            for (Cita c : Citas) {
                salida.println(c.getId() + "-"
                        + c.getPaciente().getDni() + "-"
                        + c.getPaciente().getNombres() + "-"
                        + c.getOdontologo().getNombre() + "-"
                        + c.getMotivo() + "-"
                        + c.getFecha().fechaAbreviada() + "-"
                        + c.getHora().horaAbreviada() + "-"
                        + c.getAlergias() + "-"
                        + c.getEstadoCita());
            }
            salida.close();
        }
    }

    public Stack<Cita> leer(LinkedList<Paciente> pacientes, ArrayList<Odontologo> odontologos) throws IOException {
        Stack<Cita> citas = new Stack<>();
        try (FileReader fr = new FileReader("Citas.txt");
             BufferedReader entrada = new BufferedReader(fr)) {

            String s;
            while((s = entrada.readLine()) != null){
                String[] informacion = s.split("-");
                if (informacion.length == 9){
                    String idCita = informacion[0];
                    String dniPaciente = informacion[1];
                    String nombrePaciente = informacion[2];
                    String nombreOdontologo = informacion[3];
                    String motivo = informacion[4];
                    String fechaAbreviada = informacion[5];
                    String horaAbreviada = informacion[6];
                    String alergias = informacion[7];
                    String estado = informacion[8];

                    Paciente paciente = buscarPacientePorNombre(nombrePaciente, pacientes);
                    Odontologo odontologo = buscarOdontologoPorNombre(nombreOdontologo, odontologos);

                    if(paciente != null && odontologo != null){
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
    public void actualizarCita(String dniPaciente, Fecha nuevaFecha, Hora nuevaHora, String nuevoEstado, Stack<Cita> citas) throws IOException {
        boolean citaActualizada = false;
        for(Cita cita : citas) {
            if(cita.getPaciente().getDni().equals(dniPaciente)) {
                cita.setFecha(nuevaFecha);
                cita.setHora(nuevaHora);
                cita.setEstadoCita(nuevoEstado);
                citaActualizada = true;
                System.out.println("Cita actualizada correctamente");
                break;
            }
        }

        if(citaActualizada){
            // Si la cita fue encontrada y actualizada, escribir las citas al archivo
            escribir(citas);
        }else{
            System.out.println("No se encontró una cita para el paciente con DNI: " + dniPaciente);
        }
    }
    private Paciente buscarPacientePorNombre(String nombre, LinkedList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombres().equals(nombre)) {
                return paciente;
            }
        }
        return null;
    }

    private Odontologo buscarOdontologoPorNombre(String nombre, ArrayList<Odontologo> odontologos) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNombre().equals(nombre)) {
                return odontologo;
            }
        }
        return null;
    }

    public void guardarCita(Cita nuevaCita, Stack<Cita> citas) throws IOException {
        citas.push(nuevaCita);
        escribir(citas);
    }
}

