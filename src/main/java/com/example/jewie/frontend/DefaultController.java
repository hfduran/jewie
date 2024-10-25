package com.example.jewie.frontend;

import com.example.jewie.frontend.exceptions.FxmlLoadException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class DefaultController {
    private Scene tryLoadFXML(String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        return new Scene(fxmlLoader.load(), 300, 200);
    }

    protected Scene loadFXML(String path) {
        try {
            return tryLoadFXML(path);
        } catch (Exception e) {
            throw new FxmlLoadException(path);
        }
    }
}
