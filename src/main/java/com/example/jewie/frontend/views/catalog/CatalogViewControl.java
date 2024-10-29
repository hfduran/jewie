package com.example.jewie.frontend.views.catalog;

import com.example.jewie.backend.Stock;
import com.example.jewie.backend.pieces.Piece;
import com.example.jewie.frontend.views.HomeViewController;
import com.example.jewie.frontend.views.ViewControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CatalogViewControl extends ViewControl implements Initializable {
    @FXML
    protected VBox cardsContainer;

    @Override
    protected String getViewPath() {
        return "catalog-view.fxml";
    }

    private void addCards() {
        List<Piece> pieces = Stock.getInstance().getPieces();
        for (Piece piece : pieces) {
            CatalogCardViewControl cardViewControl = new CatalogCardViewControl();
            cardViewControl.setData(piece.getName(),
                    piece.getCode(),
                    piece.getCatalogPrice(),
                    piece.getType().toString());
            cardsContainer.getChildren().add(cardViewControl.getParent());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addCards();
    }

    @FXML
    protected void onBackHomeButtonClick(ActionEvent event) {
        HomeViewController homeControl = new HomeViewController();
        Scene scene = homeControl.getScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
