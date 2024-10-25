package com.example.jewie.frontend;

import com.example.jewie.frontend.core.FXMLLoaderWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PiecesController {

    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        FXMLLoaderWrapper fxmlLoader = new FXMLLoaderWrapper();
        Scene scene = fxmlLoader.loadFXMLToScene(getClass().getResource("home-view.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
