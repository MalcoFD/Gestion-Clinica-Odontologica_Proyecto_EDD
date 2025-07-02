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
import java.util.Stack;
import java.io.File;

public class HistorialCita {

    // Método para verificar si una cita ya existe en el archivo basado en el ID
    private boolean citaExistenteEnHistorial(String archivoHistorial, Cita citaNueva) throws IOException {
        File archivo = new File(archivoHistorial);
        if (!archivo.exists()) {
            return false; // Si el archivo no existe, la cita no puede estar registrada
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoHistorial))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Comparamos solo el ID de la cita
                String[] datos = line.split("-");
                if (datos[0].equals(citaNueva.getId())) {
                    return true; // Cita con el mismo ID ya registrada en el archivo
                }
            }
        }
        return false; // Cita no encontrada en el archivo
    }

    // Método para crear o actualizar el historial de citas
    public void crearHistorial(String dniPaciente, Stack<Cita> citas) throws IOException {
        String archivoHistorial = dniPaciente + "-citas.txt";
        File archivo = new File(archivoHistorial);
        boolean archivoExiste = archivo.exists();

        try (FileWriter fw = new FileWriter(archivoHistorial, true); // 'true' para modo append
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter salida = new PrintWriter(bw)) {

            for (Cita cita : citas) {
                if (cita.getPaciente().getDni().equals(dniPaciente)) {
                    // Verificar si la cita ya existe en el archivo
                    if (!citaExistenteEnHistorial(archivoHistorial, cita)) {
                        salida.println(cita.getId() + "-"
                                + cita.getPaciente().getDni() + "-"
                                + cita.getPaciente().getNombres() + "-"
                                + cita.getOdontologo().getNombre() + "-"
                                + cita.getMotivo() + "-"
                                + cita.getFecha().fechaAbreviada() + "-"
                                + cita.getHora().horaAbreviada() + "-"
                                + cita.getAlergias() + "-"
                                + cita.getEstadoCita());
                        System.out.println("Cita añadida al historial de " + dniPaciente);
                    } else {
                        System.out.println("La cita ya está registrada en el historial de " + dniPaciente);
                    }
                }
            }
        }
    }

    // Método para generar el historial de citas
    public void generarHistorialDeCitas(String dniPaciente, Stack<Cita> citas) throws IOException {
        crearHistorial(dniPaciente, citas); // Crear o actualizar el historial de citas para el paciente
    }
}

