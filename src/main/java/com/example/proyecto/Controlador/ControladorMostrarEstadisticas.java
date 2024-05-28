package com.example.proyecto.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ControladorMostrarEstadisticas {


    @FXML
    private PieChart pieChart;

    public void initialize(){

        List<String[]> jugadores = leerArchivoMaximosGoleadores();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (String[] jugador : jugadores) {
            String nombreJugador = jugador[1] + jugador[2] + " = " + Integer.parseInt(jugador[7].trim());
            int goles = Integer.parseInt(jugador[7].trim());
            pieChartData.add(new PieChart.Data(nombreJugador, goles));
        }
        pieChart.setData(pieChartData);
    }
    public void cambiarInterfazMaximosGoleadores(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazMaximosGoleadores.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }

    public void leerArchivoEquipos(){
        File archivo = new File("src/main/java/com/example/proyecto/Controlador/equipos.txt");
        File archivo2 = new File("src/main/java/com/example/proyecto/Controlador/maximosGoleadores.txt");
        ArrayList<Club> arrayClub = new ArrayList<>();
        Scanner lector = null;
        FileWriter fw = null;
        try {
            lector = new Scanner(archivo);

            while (lector.hasNext()){
                String linea = lector.nextLine();
                String[] array = linea.split("\\|");

                arrayClub.add(new Club(array[0].trim(), array[1].trim(), array[2].trim(), Integer.parseInt(array[3].trim()), array[4].trim(), Integer.parseInt(array[5].trim()), Integer.parseInt(array[6].trim()), Integer.parseInt(array[7].trim()), Integer.parseInt(array[8].trim())));
            }

            arrayClub = arrayClub.stream().sorted((o1, o2) -> o2.goles - o1.goles).collect(Collectors.toCollection(ArrayList::new));
            fw = new FileWriter(archivo2);
            for (int i = 0; i <3; i++) {
                Club club = arrayClub.get(i);
                fw.write(club.toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lector.close();
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String[]> leerArchivoMaximosGoleadores(){
        File archivo = new File("src/main/java/com/example/proyecto/Controlador/maximosGoleadores.txt");
        Scanner lector = null;
        String[] array = null;
        List<String[]> jugadores = new ArrayList<>();
        try {
            lector = new Scanner(archivo);
            while (lector.hasNext()){
                String linea = lector.nextLine();
                array = linea.split("\\|");
                jugadores.add(array);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            lector.close();
        }
        return jugadores;
    }

    public void volverInterfazInformacionEstadisticas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazInformacionEstadisticas.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void cambiarInterfazBuena(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyecto/InterfazBuena.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }

}
