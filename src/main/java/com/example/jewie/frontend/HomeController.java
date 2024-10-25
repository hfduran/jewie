package com.example.jewie.frontend;

import com.example.jewie.frontend.core.FXMLLoaderWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    protected void onPiecesButtonClick(ActionEvent event) {
        FXMLLoaderWrapper fxmlLoader = new FXMLLoaderWrapper();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = fxmlLoader.loadFXMLToScene(getClass().getResource("pieces-view.fxml"));

        stage.setScene(scene);
        stage.show();
    }
}
