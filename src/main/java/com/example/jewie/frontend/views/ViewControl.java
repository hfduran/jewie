package com.example.jewie.frontend.views;

import com.example.jewie.frontend.exceptions.FxmlLoadException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public abstract class ViewControl extends VBox {
    public ViewControl() {
        URL url = getViewURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch(IOException e) {
            throw new FxmlLoadException(getViewPath());
        }
    }

    public Scene createScene() {
        return new Scene(this, 800, 600);
    }

    protected abstract String getViewPath();

    private URL getViewURL() {
        return getClass().getResource(getViewPath());
    }

}
