package com.example.proyecto.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ControladorMostrarJugadores {
    public TextField nombreEquipo;
    @FXML
    private ListView<String> listaEquipos;

    private Modelo modelo;
    private Equipo equipo;
    private Jugador jugador;
    File archivo = new File("src/main/java/com/example/proyecto/Controlador/equipos.txt");
    public void initialize() {
        modelo = modelo.getInstance();
        equipo = modelo.getEquipo();
        leerArchivoNombreYApellidos();
    }

    public void confirmar(){
        if (nombreEquipo.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("El nombre del equipo es obligatorio.");
            alert.showAndWait();
            return;
        }
        escribirEquipo();
        leerArchivo(archivo);
        leerArchivoNombreYApellidos();
    }

    public void cambiarInterfazMostrar(ActionEvent event) throws IOException {
        if (nombreEquipo.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Validación");
            alert.setHeaderText(null);
            alert.setContentText("El nombre del equipo es obligatorio.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazMostrarJugadores.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

    public void leerArchivo(File archivo) {
        Scanner lector = null;
        FileWriter fw = null;
        try {
            lector = new Scanner(archivo);
            File archivoJugadores = new File("src/main/java/com/example/proyecto/Controlador/jugadores.txt");
            fw = new FileWriter(archivoJugadores);
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] partes = linea.split("\\|");

                if (partes[0].trim().equals(equipo.getNombreEquipo().toUpperCase().trim())) {
                    fw.write(partes[1].trim() +" " + partes[2].trim() + "\n");
                    fw.flush();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (lector != null) {
                lector.close();
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

public String leerArchivoNombreYApellidos(){
        File archivoNombreApellido = new File("src/main/java/com/example/proyecto/Controlador/jugadores.txt");
    Scanner lector = null;
    String linea = "";
    try {
        lector = new Scanner(archivoNombreApellido);
        while (lector.hasNext()){
            linea = lector.nextLine();
            listaEquipos.getItems().add(linea);
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }finally {
        lector.close();
    }
    return linea;
}



    public void volverInterfaz1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazBuena.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
