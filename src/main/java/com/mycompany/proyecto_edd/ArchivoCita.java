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
import java.util.ArrayList;

public class ArchivoCita {
    //Escribir en el archivo
    public void escribir(Stack<Cita> Citas) throws IOException {
        FileWriter fw = new FileWriter("Citas.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);

        for (Cita c : Citas) {
            salida.println(c.getId() + "-"
                    + c.getPaciente().getNombre() + "-"
                    + c.getOdontologo().getNombre() + "-"
                    + c.getMotivo() + "-"
                    + c.getFecha().fechaAbreviada() + "-"
                    + c.getHora().horaAbreviada() + "-"
                    + c.getAlergias() + "-"
                    + c.getEstadoCita());
        }
        salida.close();
    }

    public Stack<Cita> leer(ArrayList<Paciente> pacientes, ArrayList<Odontologo> odontologos) throws IOException{
        Stack<Cita> citas = new Stack<>();
        FileReader fr=new FileReader("Citas.txt");
        BufferedReader entrada =new BufferedReader(fr);
        String s, s2 = new String();

        //Hacemos un bucle hasta que encuentre una linea vacia
        while((s=entrada.readLine())!=null){
            s2 += s + "\n";
            //Con el metodo split separamos a los elementos por el delimitador "-"
            String[] informacion = s.split("-");
            String idCita = informacion[0];
            String nombrePaciente = informacion[1];
            String nombreOdontologo = informacion[2];
            String motivo = informacion[3];
            String fechaAbreviada = informacion[4];
            String horaAbreviada = informacion[5];
            String alergias = informacion[6];
            String estado = informacion[7];

            Paciente paciente = buscarPacientePorNombre(nombrePaciente, pacientes);
            Odontologo odontologo = buscarOdontologoPorNombre(nombreOdontologo, odontologos);

            String[] partesFecha = fechaAbreviada.split("/");
            int dia = Integer.parseInt(partesFecha[0]);
            int mes = Integer.parseInt(partesFecha[1]);
            int anio = Integer.parseInt(partesFecha[2]);
            Fecha fecha = new Fecha(dia, mes, anio);

            String[] partesHora = horaAbreviada.split(":");
            int horas = Integer.parseInt(partesHora[0]);
            int minutos = Integer.parseInt(partesHora[1]);
            Hora hora = new Hora(horas, minutos);

            Cita cita = new Cita(idCita,paciente, odontologo, motivo,fecha, hora,alergias,estado);

            citas.push(cita);
        }
        entrada.close();

        return citas;
    }

    private Paciente buscarPacientePorNombre(String nombre, ArrayList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equals(nombre)) {
                return paciente;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Metodo auxiliar para buscar un médico por su nombre
    private Odontologo buscarOdontologoPorNombre(String nombre, ArrayList<Odontologo> odontologos) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNombre().equals(nombre)) {
                return odontologo;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public void guardarCita(Cita nuevaCita, Stack<Cita> citas) throws IOException {
        // Guardamos la lista actualizada de citas en el archivo
        escribir(citas);
    }

}

