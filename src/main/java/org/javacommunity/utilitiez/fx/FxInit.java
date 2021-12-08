package org.javacommunity.utilitiez.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 19:40
 */

public class FxInit extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFx.class.getResource("MainFx.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Utilitiez - By JavaCommunity");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
