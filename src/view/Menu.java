package view;

import view.Chart;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application{

    public static void startUp() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analytics");
        Button btn = new Button();
        btn.setText("Check buttons clicks from array");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int[] buttons_clicks = {13, 34, 234, 52, 123, 74, 149};
                Stats stats = new Stats();
                stats.print_stats(buttons_clicks);
            }
        });

        Button btn_json = new Button();
        btn_json.setText("Check buttons clicks from json file");
        btn_json.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Not yet!");
            }
        });

        StackPane root = new StackPane();
        btn.setLayoutX(100);
        btn.setLayoutY(10);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}
