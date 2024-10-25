package com.example.jewie.frontend;

import com.example.jewie.frontend.core.FXMLLoaderWrapper;
import com.example.jewie.frontend.core.GlobalExceptionHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> handler.handle(throwable));

        FXMLLoaderWrapper fxmlLoader = new FXMLLoaderWrapper();
        Scene scene = fxmlLoader.loadFXMLToScene(getClass().getResource("home-view.fxml"));
        stage.setTitle("Jewie - Welcome!");
        stage.setScene(scene);
        stage.show();
    }
}
