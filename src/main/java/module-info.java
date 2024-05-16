module com.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto to javafx.fxml;
    exports com.example.proyecto;

    exports com.example.proyecto.Controlador;
    opens com.example.proyecto.Controlador to javafx.fxml;

    exports com.example.proyecto.Modelo;
    opens com.example.proyecto.Modelo to javafx.fxml;
}