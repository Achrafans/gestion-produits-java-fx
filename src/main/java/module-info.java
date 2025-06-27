module net.achraf.gestionproduits {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens net.achraf.gestionproduits.controllers to javafx.fxml;
    opens net.achraf.gestionproduits.entities to javafx.base;
    exports net.achraf.gestionproduits;
}