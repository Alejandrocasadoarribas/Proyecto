package com.example.proyecto.Controlador;

public class Jugador {
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

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                ", minutosJugados=" + minutosJugados +
                ", goles=" + goles +
                ", asistencias=" + asistencias;
    }
}
