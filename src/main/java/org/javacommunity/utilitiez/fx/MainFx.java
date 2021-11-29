package org.javacommunity.utilitiez.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainFx {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
