package com.example.proyecto.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorInsertar {

    public TextField nombreEquipo;
    public TextField nombreJugador;
    public TextField apellido;
    public TextField edad;
    public TextField minutosJugados;
    public TextField posicion;
    public TextField dorsal;
    public TextField goles;
    public TextField asistencias;

    File archivo = new File("src/main/java/com/example/proyecto/Controlador/equipos.txt");

    private Modelo modelo;
    private Equipo equipo;

    public void initialize() {
        modelo = Modelo.getInstance();
        equipo = modelo.getEquipo();
    }


    public void cambiarInterfaz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInsertarEquipo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void cambiarInterfaz2(ActionEvent event) throws IOException {
        if (nombreEquipo.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("El nombre del equipo es obligatorio.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInsertarJugadores.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        escribirEquipo();
    }

    public void escribirEquipo(){
        String nombre = nombreEquipo.getText().trim();
        if (nombre.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("El nombre del equipo es obligatorio.");
            alert.showAndWait();
            return;
        }
        equipo.setNombreEquipo(nombre);
    }

    public void guardarDatos() {
        try {
            if (nombreJugador.getText().trim().isEmpty() ||
                    apellido.getText().trim().isEmpty() ||
                    edad.getText().trim().isEmpty() ||
                    minutosJugados.getText().trim().isEmpty() ||
                    posicion.getText().trim().isEmpty() ||
                    dorsal.getText().trim().isEmpty() ||
                    goles.getText().trim().isEmpty() ||
                    asistencias.getText().trim().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Validación");
                alert.setHeaderText(null);
                alert.setContentText("Todos los campos son obligatorios.");
                alert.showAndWait();
                return;
            }
            String nombre = nombreJugador.getText().trim();
            String apellidoJugador = apellido.getText().trim();
            int edadJugador = Integer.parseInt(edad.getText().trim());
            String minutos = minutosJugados.getText().trim();
            int posicionJugador = Integer.parseInt(posicion.getText().trim());
            int dorsalJugador = Integer.parseInt(dorsal.getText().trim());
            int golesJugador = Integer.parseInt(goles.getText().trim());
            int asistenciasJugador = Integer.parseInt(asistencias.getText().trim());

            Jugador jugador = new Jugador(nombre, apellidoJugador, edadJugador, minutos, posicionJugador, dorsalJugador, golesJugador, asistenciasJugador);
            equipo.añadirJugador(jugador);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("La edad, posición, dorsal, goles y asistencias deben ser números enteros.");
            alert.showAndWait();
        }
    }

    public void escribirDatosJugadores(){

        if (!equipo.datosCompletos()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("Faltan datos del equipo o jugadores.");
            alert.showAndWait();
            return;
        }
        FileWriter fw = null;
            try {
                fw = new FileWriter(archivo,true);
                fw.write("\n" + equipo.getNombreEquipo() + " | ");
                for (Jugador jugador:equipo.getJugadores()) {
                    fw.write(jugador + " | ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println("No se puede cerrar el fw");
                }
            }
    }

    public void volverInterfaz1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/Interfaz1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void volverInterfazInsertarEquipo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInsertarEquipo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    //NOS VAMOS YA A LA SEGUNDA PESTAÑA LLAMADA BUSCAR

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}