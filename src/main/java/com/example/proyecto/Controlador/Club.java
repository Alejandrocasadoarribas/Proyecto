package com.example.proyecto.Controlador;

public class Club {
    String nombreEquipo;
    String nombre;
    String apellido1;
    int edad;
    String posicion;
    int dorsal;
    int minutosJugados;
    int goles;
    int asistencias;

    public Club(String nombreEquipo, String nombre, String apellido1, int edad, String posicion, int dorsal, int minutosJugados, int goles, int asistencias) {
        this.nombreEquipo = nombreEquipo;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.edad = edad;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.minutosJugados = minutosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return nombreEquipo + " | " + nombre + " | " + apellido1 + " | " + edad + " | " + posicion + " | " + dorsal + " | " + minutosJugados + " | " + goles + " | " + asistencias;
    }
}
