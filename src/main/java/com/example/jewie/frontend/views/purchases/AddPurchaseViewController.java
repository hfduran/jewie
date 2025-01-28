package com.example.jewie.frontend.views.purchases;

import com.example.jewie.backend.Financial;
import com.example.jewie.backend.Stock;
import com.example.jewie.backend.bunches.ReceivedBunch;
import com.example.jewie.backend.finance.Purchase;
import com.example.jewie.backend.pieces.Piece;
import com.example.jewie.frontend.views.HomeViewController;
import com.example.jewie.frontend.views.ViewController;
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
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class AddPurchaseViewController extends ViewController implements Initializable {
    @FXML
    protected ComboBox<Piece> pieceComboBox;
    @FXML
    protected TextField qtyTextInput;
    @FXML
    protected TextField valueTextInput;
    @FXML
    protected Button addBunchButton;
    @FXML
    protected Button finalizeButton;

    private HashMap<Piece, ReceivedBunch> receivedBunchesMap = new HashMap<>();

    @Override
    protected String getViewPath() {
        return "add-purchase-view.fxml";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Piece> pieces = Stock.getInstance().getPieces();
        this.pieceComboBox.getItems().addAll(pieces);
        this.finalizeButton.disableProperty()
                .bind(Bindings.createBooleanBinding(() -> !hasBunches() ||
                        this.valueTextInput.getText().isBlank(), valueTextInput.textProperty()));
        this.addBunchButton.disableProperty()
                .bind(Bindings.createBooleanBinding(() -> this.pieceComboBox.getValue() == null ||
                                this.qtyTextInput.getText().isBlank(),
                        pieceComboBox.valueProperty(),
                        qtyTextInput.textProperty()));
    }

    private boolean hasBunches() {
        return !this.receivedBunchesMap.isEmpty();
    }

    private void clearAddBunchesInputs() {
        pieceComboBox.setValue(null);
        qtyTextInput.setText("");
    }

    @FXML
    protected void addReceivedBunch() {
        Piece piece = pieceComboBox.getValue();
        ReceivedBunch receivedBunch = this.receivedBunchesMap.get(piece);
        if (receivedBunch == null) {
            receivedBunch = new ReceivedBunch(piece, Integer.parseInt(qtyTextInput.getText()));
        } else {
            receivedBunch = new ReceivedBunch(piece,
                    receivedBunch.getQty() + Integer.parseInt(qtyTextInput.getText()));
        }
        this.receivedBunchesMap.put(piece, receivedBunch);
        this.clearAddBunchesInputs();
    }

    private Purchase createPurchase() {
        Purchase purchase = new Purchase(this.receivedBunchesMap.values().stream().toList(),
                Double.parseDouble(valueTextInput.getText()));
        this.valueTextInput.setText("");
        return purchase;
    }

    @FXML
    protected void onSubmit() {
        Purchase purchase = this.createPurchase();
        Financial.getInstance().addPurchase(purchase);
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
