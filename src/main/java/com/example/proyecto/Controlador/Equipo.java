package com.example.proyecto.Controlador;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    String nombreEquipo;

    private List<Jugador> jugadores;

    public Equipo() {
        jugadores = new ArrayList<>();
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean datosCompletos() {
        return nombreEquipo != null && !nombreEquipo.isEmpty() && !jugadores.isEmpty();
    }
}
