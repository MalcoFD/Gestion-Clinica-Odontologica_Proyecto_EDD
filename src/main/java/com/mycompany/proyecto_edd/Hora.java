/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */
public class Hora {
    // Atributos
    final private int horas;
    final private int minutos;

    // Constructor
    public Hora(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    // Métodos para obtener la hora y los minutos
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    // Método para devolver la hora en formato abreviado
    public String horaAbreviada() {
        return String.format("%02d:%02d", horas, minutos);
    }

}
