package com.example.jewie.frontend.views;

import com.example.jewie.frontend.exceptions.FxmlLoadException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public abstract class ViewControl {
    protected abstract String getViewPath();

    private URL getViewURL() {
        return getClass().getResource(getViewPath());
    }

    public Scene getScene() {
        URL url = getViewURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(c -> {
            return this;
        });

        try {
            return new Scene(fxmlLoader.load(), 800, 600);
        } catch (IOException e) {
            throw new FxmlLoadException(getViewPath());
        }
    }
}
