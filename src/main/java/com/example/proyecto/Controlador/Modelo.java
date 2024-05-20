package com.example.proyecto.Controlador;

public class Modelo {
        private static Modelo instance = null;
        private Equipo equipo;

        private Modelo() {
            equipo = new Equipo();
        }

        public static Modelo getInstance() {
            if (instance == null) {
                instance = new Modelo();
            }
            return instance;
        }

        public Equipo getEquipo() {
            return equipo;
        }
}
