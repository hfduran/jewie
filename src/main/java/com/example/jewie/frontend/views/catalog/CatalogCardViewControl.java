package com.example.jewie.frontend.views.catalog;

import com.example.jewie.frontend.views.ViewControl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CatalogCardViewControl extends ViewControl {
    @FXML
    protected Label nameLabel;
    @FXML
    protected Label codeLabel;
    @FXML
    protected Label priceLabel;
    @FXML
    protected Label typeLabel;

    @Override
    protected String getViewPath() {
        return "catalog-card-view.fxml";
    }

    public void setData(
            String name, String code, Double price, String type
    ) {
        nameLabel.setText(name);
        codeLabel.setText(code);
        priceLabel.setText(price.toString());
        typeLabel.setText(type);
    }
}