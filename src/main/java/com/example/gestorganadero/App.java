package com.example.gestorganadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 1440, 900);
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\Alejandro\\Desktop\\Clase\\Proyectos intlliJ\\Gestor ganadero\\src\\main\\resources\\com\\example\\gestorganadero\\Images\\IconoApp.png"));
        stage.show();
        stage.setResizable(false);
    }

    protected static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}