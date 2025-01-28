package com.example.jewie.frontend.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public abstract class ViewController {
    private final FXMLLoader fxmlLoader;
    private Parent parent;

    public ViewController() {
        fxmlLoader = new FXMLLoader(getViewURL());
        configureFxmlLoader();
        createParent();
    }

    private void configureFxmlLoader() {
        fxmlLoader.setControllerFactory(c -> {
            return this;
        });
    }

    protected abstract String getViewPath();

    private URL getViewURL() {
        return getClass().getResource(getViewPath());
    }

    private void createParent() {
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            // throw new FxmlLoadException(getViewPath());
            throw new RuntimeException(e);
        }
    }

    public Parent getParent() {
        if (parent == null) {
            createParent();
        }
        return parent;
    }

    public Scene getScene() {
        return new Scene(getParent(), 600, 400);
    }
}
