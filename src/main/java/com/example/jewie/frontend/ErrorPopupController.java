package com.example.jewie.frontend;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorPopupController {
    @FXML
    public Label errorMessage;

    private Scene getScene() {
        return errorMessage.getScene();
    }

    public void close() {
        Stage stage = (Stage) this.getScene().getWindow();
        stage.close();
    }

    public void setErrorMessage(String message) {
        this.errorMessage.setText(message);
    }
}
