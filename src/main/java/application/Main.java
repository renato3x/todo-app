package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/views/main.fxml"))));

    stage.setScene(scene);
    stage.setTitle("My ToDo");
    stage.setResizable(false);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
