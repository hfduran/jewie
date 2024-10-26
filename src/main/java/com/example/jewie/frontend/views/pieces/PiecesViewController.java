package com.example.jewie.frontend.views.pieces;

import com.example.jewie.backend.pieces.PieceType;
import com.example.jewie.frontend.utils.formatters.DoubleTextFormatter;
import com.example.jewie.frontend.views.HomeViewController;
import com.example.jewie.frontend.views.ViewControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PiecesViewController extends ViewControl implements Initializable {

    public TextField catalogPriceTextInput;
    public TextField nameTextInput;
    public TextField codeTextInput;

    @FXML
    private ComboBox<PieceType> typeComboBox;

    public PiecesViewController() {
        super();
        catalogPriceTextInput.setTextFormatter(DoubleTextFormatter.getFormatter());
    }

    @Override
    protected String getViewPath() {
        return "pieces-main-view.fxml";
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        HomeViewController homeControl = new HomeViewController();
        Scene scene = homeControl.createScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeComboBox.getItems().addAll(PieceType.values());
    }
}
