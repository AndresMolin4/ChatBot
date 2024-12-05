package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.model.BD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ventanaRegister {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailRegister;

    @FXML
    private TextField nameRegister;

    @FXML
    private TextField passRegister;

    @FXML
    void BackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ventana1.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void CreateUser(ActionEvent event) {
        String usuario = nameRegister.getText();
        String contrasena = passRegister.getText();
        String email = emailRegister.getText();
        BD modelBD = new BD();
        modelBD.CreateTable();
        modelBD.registerUser(usuario, contrasena, email);
        System.out.println("usuario: " + usuario);
        System.out.println("contraseña: " + contrasena);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro Exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Su registro fue exitoso.");
        alert.showAndWait();

    }

    @FXML
    void initialize() {
        assert emailRegister != null
                : "fx:id=\"emailRegister\" was not injected: check your FXML file 'ventanaRegister1.fxml'.";
        assert nameRegister != null
                : "fx:id=\"nameRegister\" was not injected: check your FXML file 'ventanaRegister1.fxml'.";
        assert passRegister != null
                : "fx:id=\"passRegister\" was not injected: check your FXML file 'ventanaRegister1.fxml'.";

    }

}