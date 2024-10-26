package com.example.jewie.frontend.core;

import com.example.jewie.frontend.exceptions.FxmlLoadException;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.lang.reflect.InvocationTargetException;

public class GlobalExceptionHandler {
    public void handle(Throwable unhandled) {
        unhandled.printStackTrace();
        if(unhandled instanceof RuntimeException) {
            Throwable cause = unhandled.getCause();
            if(cause instanceof InvocationTargetException) {
                cause = cause.getCause();
                if(cause instanceof FxmlLoadException) {
                    showErrorPopup("FXML Load Error", cause.getMessage());
                    return;
                }
            }
        }
        defaultHandle(unhandled);
    }

    private void defaultHandle(Throwable throwable) {
        showErrorPopup("An unexpected error occurred!",throwable.getMessage());
    }

    private void showErrorPopup(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(title);
            alert.setContentText(message);

            alert.showAndWait();
        });
    }
}
