package com.example.jewie.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PiecesView {
    private Scene loadFXML(String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        return new Scene(fxmlLoader.load(), 300, 200);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        Scene scene = this.loadFXML("home-view.fxml");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
