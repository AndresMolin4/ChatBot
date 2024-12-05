package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.BD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ventana1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML 
    private PasswordField password; 
    @FXML 
    private TextField user;

    @FXML
    void CreateButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ventanaRegister1.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void LoginButton(ActionEvent event) throws IOException {
        String usuario = user.getText();
        String contrasena = password.getText();
        BD model1 = new BD();

    boolean ValidUser = model1.validateUser(usuario, contrasena);
    
    if (ValidUser) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ventana2.fxml"));
        Scene scene = new Scene(loader.load());
        ventana2Controller window2Controller = loader.getController();
        window2Controller.setUserName(usuario);

        Stage stage = (Stage) user.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } else {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuario no encontrado");
        alert.setHeaderText(null);
        alert.setContentText("El usuario o la contraseña no son correctos");
        alert.showAndWait();
    }
}
    @FXML
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'ventana1.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'ventana1.fxml'.";

    }

}