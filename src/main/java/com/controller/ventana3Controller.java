package com.controller;

import java.io.IOException;

import com.model.BD;
import com.model.LmStudio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ventana3Controller {

    @FXML
    private Label RecomendacionF;

    @FXML
    private TextField interaccion;
    @FXML
    void enviarConsulta(ActionEvent event) {
        String mensaje = interaccion.getText();
        String respuesta = LmStudio.Recommendations_0(mensaje);
        RecomendacionF.setText(respuesta);
        BD modelDB = new BD();
        modelDB.guardar(mensaje, respuesta);
    }

    @FXML
    void ButtonBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ventana2.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void DeleteAllButton(ActionEvent event) {
        BD Delete = new BD();
        Delete.deleteAll();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Historial");
        alert.setHeaderText(null);
        alert.setContentText("El historial en la base de datos ha sido borrado");
        alert.showAndWait();
        

    }

    @FXML
    void showHistorialButton(ActionEvent event) throws IOException {
        BD modelDB = new BD();
        modelDB.select();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Historial");
        alert.setHeaderText(null);
        alert.setContentText("--- El historial se encuentra en la terminal ---");
        alert.showAndWait();

    }

    @FXML
    void initialize() {
        assert RecomendacionF != null : "fx:id=\"RecomendacionF\" was not injected: check your FXML file 'ventana3.fxml'.";
        assert interaccion != null : "fx:id=\"interaccion\" was not injected: check your FXML file 'ventana3.fxml'.";
    }
}