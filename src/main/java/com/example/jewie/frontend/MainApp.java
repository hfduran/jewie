package com.example.jewie.frontend;

import com.example.jewie.HelloApplication;
import com.example.jewie.frontend.core.GlobalExceptionHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent, 320, 240);
        stage.setTitle("Jewie - Welcome!");
        stage.setScene(scene);
        stage.show();
    }
}
