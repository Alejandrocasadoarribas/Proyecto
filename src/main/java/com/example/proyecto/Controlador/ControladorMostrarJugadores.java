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
import java.io.IOException;
import java.util.*;

public class ControladorMostrarJugadores {
    public TextField nombreEquipo;
    @FXML
    private ListView<String> listaEquipos;

    private Modelo modelo;
    private Equipo equipo;
    File archivo = new File("src/main/java/com/example/proyecto/Controlador/equipos.txt");
    public void initialize() {
        modelo = modelo.getInstance();
        equipo = modelo.getEquipo();
        String[] equipos = leerArchivo(archivo);
        listaEquipos.getItems().add(Arrays.toString(equipos));
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

    public String[] leerArchivo(File archivo) {
        Scanner lector = null;
        String[] partes = new String[0];
        try {
            lector = new Scanner(archivo);
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                partes = linea.split("\\|");
                System.out.println(Arrays.toString(partes));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            lector.close();
        };
        return partes;
    }


    public void volverInterfaz1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazBuena.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
