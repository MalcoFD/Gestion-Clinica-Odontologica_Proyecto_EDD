/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_edd;

/**
 *
 * @author FAS
 */
public class Fecha {
    //Atributos
    private int dia;
    private int mes;
    private int anio;

    //Métodos

    //Constructor
    public Fecha(int dia, int mes, int anio) {
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }



    //Método para verificar si el año es bisiesto
    public boolean esBisiesto(int anio) {
        return (anio%4==0 && anio%100!=0) || (anio%400==0);
    }

    //Método para verificar que se ingrese una fecha real
    public boolean validarFecha(){
        if(dia>0 && dia<=this.diaMes()){
            if(mes>=1 && mes<=12){
                if(anio>0){
                    return true;
                }
            }
        }
        return false;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    //Método para devolver el número de días de cada mes
    public int diaMes(){
        switch(mes){
            case 1: // Enero
            case 3: // Marzo
            case 5: // Mayo
            case 7: // Julio
            case 8: // Agosto
            case 10: // Octubre
            case 12: // Diciembre
                return 31;

            case 4: // Abril
            case 6: // Junio
            case 9: // Septiembre
            case 11: // Noviembre
                return 30;
            case 2: // Febrero
                if(esBisiesto(anio)){
                    return 29;
                }
                else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    //Método para devolver la fecha de forma abreviada
    public String fechaAbreviada(){
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }

    //Método para devolver el mes en forma de cadena
    public String mesExtendido(){
        String[] meses={"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
                "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

        return meses[mes-1];
    }

    //Método para devolver el mes de forma extendida
    public String fechaExtendida(){
        return String.format("%d de %s de %d", dia, mesExtendido(), anio);
    }

    //Método para incrementar un dia y actualizar el mes y el año
    public void incrementaUnDia(){
        dia++;
        if(dia>this.diaMes()){
            dia=1;
            mes++;
            if(mes>12){
                mes=1;
                anio++;
            }
        }
    }

    //Método para incrementar la fecha en un numero de días dado
    public void incremento(int numero){
        int i=0;
        while(i<numero){
            incrementaUnDia();
            i++;
        }
    }
}
