package com.example.proyecto.Controlador;

public class Jugador{
    String nombre;
    String apellido1;
    int edad;
    String posicion;
    int dorsal;
    int minutosJugados;
    int goles;
    int asistencias;

    public Jugador(String nombre, String apellido1, int edad, String posicion, int dorsal, int minutosJugados, int goles, int asistencias) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.edad = edad;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.minutosJugados = minutosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
    }


    public Jugador(String linea) {
        String[] datos = linea.split(" , ");
        this.nombre = datos[1];
        this.apellido1 = datos[1];
        this.edad = Integer.parseInt(datos[2]);
        this.minutosJugados = Integer.parseInt(datos[3]);
        this.posicion = datos[4];
        this.dorsal = Integer.parseInt(datos[5]);
        this.goles = Integer.parseInt(datos[6]);
        this.asistencias = Integer.parseInt(datos[7]);
    }

    @Override
    public String toString() {
        return nombre + " | " + apellido1 + " | " + edad + " | " + posicion + " | " + dorsal+ " | " + minutosJugados + " | " + goles + " | " + asistencias;
    }

}
