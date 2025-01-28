package com.example.jewie.frontend;

import com.example.jewie.frontend.core.GlobalExceptionHandler;
import com.example.jewie.frontend.views.HomeViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> handler.handle(throwable));

        HomeViewController homeControl = new HomeViewController();
        Scene scene = homeControl.getScene();

        stage.setTitle("Jewie - Welcome!");
        stage.setScene(scene);
        stage.show();
    }
}
