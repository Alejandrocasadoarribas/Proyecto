package com.example.proyecto.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    HashMap<String, ArrayList<Jugador>> mapaEquipos = new HashMap<>();

    File archivo = new File("src/main/java/com/example/proyecto/Controlador/equipos.txt");

    public void cambiarInterfaz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInsertarEquipo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void cambiarInterfaz2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInsertarJugadores.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
    public void escribirEquipo(){
        FileWriter fw = null;
        try {
            fw = new FileWriter(archivo,true);
            fw.write("\n" + nombreEquipo.getText() + " | ");

        }catch (NullPointerException e){
            System.out.println("No se ha podido escribir e nombre del equipo");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void escribirDatosJugadores() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(archivo,true);
            ArrayList<Jugador> jugadores = new ArrayList<>();

            jugadores.add((new Jugador(nombreJugador.getText(),apellido.getText(),Integer.parseInt(edad.getText()),minutosJugados.getText(),Integer.parseInt(posicion.getText()),Integer.parseInt(dorsal.getText()),Integer.parseInt(goles.getText()),Integer.parseInt(asistencias.getText()))));
            fw.write(String.valueOf(jugadores));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}