package com.example.jewie.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PiecesController extends DefaultController {

    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        Scene scene = this.loadFXML("hom-view.fxml");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
