package com.example.jewie.frontend.views.pieces;

import com.example.jewie.backend.Stock;
import com.example.jewie.backend.pieces.Piece;
import com.example.jewie.backend.pieces.PieceType;
import com.example.jewie.frontend.utils.formatters.DoubleTextFormatter;
import com.example.jewie.frontend.views.HomeViewController;
import com.example.jewie.frontend.views.ViewControl;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PiecesViewController extends ViewControl implements Initializable {
    @FXML
    protected TextField catalogPriceTextInput;
    @FXML
    protected TextField nameTextInput;
    @FXML
    protected TextField codeTextInput;
    @FXML
    protected Button submitButton;
    @FXML
    private ComboBox<PieceType> typeComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catalogPriceTextInput.setTextFormatter(DoubleTextFormatter.getFormatter());
        typeComboBox.getItems().addAll(PieceType.values());
        submitButton.disableProperty()
                .bind(Bindings.createBooleanBinding(() -> !inputsReady(),
                        catalogPriceTextInput.textProperty(),
                        nameTextInput.textProperty(),
                        codeTextInput.textProperty(),
                        typeComboBox.valueProperty()));
    }

    @Override
    protected String getViewPath() {
        return "pieces-main-view.fxml";
    }

    private boolean inputsReady() {
        return !(codeTextInput.getText().isBlank() || nameTextInput.getText().isBlank() ||
                catalogPriceTextInput.getText().isBlank() || typeComboBox.getValue() == null);
    }

    private void clearInputs() {
        nameTextInput.setText("");
        codeTextInput.setText("");
        catalogPriceTextInput.setText("");
        typeComboBox.setValue(null);
    }

    @FXML
    protected void onSubmit() {
        Piece newPiece = new Piece(codeTextInput.getText(),
                nameTextInput.getText(),
                Double.parseDouble(catalogPriceTextInput.getText()),
                typeComboBox.getValue());
        Stock.getInstance().addPiece(newPiece);
        clearInputs();
    }


    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        HomeViewController homeControl = new HomeViewController();
        Scene scene = homeControl.getScene();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
