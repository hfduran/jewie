package com.example.jewie.frontend.core;

import com.example.jewie.frontend.exceptions.FxmlLoadException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class FXMLLoaderWrapper {
    private Scene tryLoadFXML(URL url, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        return new Scene(fxmlLoader.load(),width, height);
    }

    public Scene loadFXMLToScene(URL url) {
        return this.loadFXMLToScene(url, 300, 200);
    }

    public Scene loadFXMLToScene(URL url, int width, int height) {
        try {
            return tryLoadFXML(url, width, height);
        } catch (Exception e) {
            throw new FxmlLoadException(url.getPath());
        }
    }
}
