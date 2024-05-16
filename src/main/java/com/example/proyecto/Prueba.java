package com.example.proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        HashMap<Integer,String> listaMadrid = new HashMap<>();
        listaMadrid.put(1,"Casillas");
        listaMadrid.put(4,"Ramos");
        listaMadrid.put(2,"Carvajal");
        listaMadrid.put(12,"Marcelo");
        listaMadrid.put(7,"Ronaldo");

        HashMap<Integer,String> listaBarcelona = new HashMap<>();
        listaBarcelona.put(1,"Ter stegen");
        listaBarcelona.put(4,"Pique");
        listaBarcelona.put(2,"Jordi Alba");
        listaBarcelona.put(10,"Messi");
        listaBarcelona.put(9,"Luis Suarez");

        HashMap<String,HashMap<Integer,String>> listaEquipos = new HashMap<>();
        listaEquipos.put("Real Madrid",listaMadrid);
        listaEquipos.put("Barcelona",listaBarcelona);

        String ruta = "src/main/java/com/example/proyecto/equipos.txt";
        File archivo = new File(ruta);
        FileWriter fw = null;
        Scanner lector = null;
        try {
            archivo.createNewFile();
            fw = new FileWriter(archivo);
            for (String equipo : listaEquipos.keySet()) {
                fw.write(equipo + " [");
                HashMap<Integer, String> jugadores = listaEquipos.get(equipo);
                for (Map.Entry<Integer, String> entry : jugadores.entrySet()) {
                    fw.write(" " + entry.getKey() + "=" + entry.getValue() + ",");
                }
                fw.write("]\n");
            }
        } catch (IOException e) {
            System.out.println("No se puede crear el archivo");
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("No se puede cerrar el archivo");
            }
        }

        try {
            lector = new Scanner(archivo);
            while (lector.hasNext()){
                String linea = lector.nextLine();

                String[] array = linea.split("\n");

                Arrays.stream(array).filter(s -> s.contains("Real Madrid")).forEach(s -> System.out.println(s + " "));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            lector.close();
        }


    }
}
