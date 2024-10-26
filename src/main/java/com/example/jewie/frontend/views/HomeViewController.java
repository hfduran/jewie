package com.example.jewie.frontend.views;

import com.example.jewie.frontend.views.pieces.PiecesViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeViewController extends ViewControl {
    @FXML
    protected void onPiecesButtonClick(ActionEvent event) {
        PiecesViewController piecesControl = new PiecesViewController();
        Scene scene = piecesControl.createScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @Override
    protected String getViewPath() {
        return "home-view.fxml";
    }
}
