module org.example.oop_project3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.desktop;

    opens org.example.oop_project3 to javafx.fxml;
    exports org.example.oop_project3;
    exports org.example.oop_project3.models;
    opens org.example.oop_project3.models to javafx.fxml;
    exports org.example.oop_project3.utils;
    opens org.example.oop_project3.utils to javafx.fxml;
    exports org.example.oop_project3.controllers;
    opens org.example.oop_project3.controllers to javafx.fxml;
}