package sample.Code;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        primaryStage.setTitle("ASGCompiler");
        primaryStage.setScene(new Scene(root, 882, 636));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
