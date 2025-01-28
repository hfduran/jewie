package com.example.jewie.frontend.views;

import com.example.jewie.frontend.views.catalog.CatalogViewController;
import com.example.jewie.frontend.views.pieces.PiecesViewController;
import com.example.jewie.frontend.views.purchases.AddPurchaseViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeViewController extends ViewController {
    @FXML
    protected void onPiecesButtonClick(ActionEvent event) {
        PiecesViewController viewControl = new PiecesViewController();
        Scene scene = viewControl.getScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onCatalogButtonClick(ActionEvent event) {
        CatalogViewController viewControl = new CatalogViewController();
        Scene scene = viewControl.getScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onAddPurchaseButtonClick(ActionEvent event) {
        AddPurchaseViewController viewControl = new AddPurchaseViewController();
        Scene scene = viewControl.getScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @Override
    protected String getViewPath() {
        return "home-view.fxml";
    }
}