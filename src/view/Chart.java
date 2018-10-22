package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {


    @Override
    public void start(Stage stage) {
        int[] buttonsClicks = {13, 34, 234, 52, 123, 74, 149};

        int win_proc = (100 * 5)/(buttonsClicks.length +4);
        int max = 0;
        for(int i = 0; i < buttonsClicks.length; i++){
            if (buttonsClicks[i] > max) max = buttonsClicks[i];
        }
        int win_clicks = max / 100 * win_proc;

        stage.setTitle("Bar Chart");
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number,String> bc =
                new BarChart<Number,String>(xAxis,yAxis);
        bc.setTitle("Buttins_clicks");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Button");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Buttons");
        int buttonsCount = buttonsClicks.length;
        //Arrays.sort(buttonsClicks);
        for ( int index = 0; index < buttonsCount; index++){
            String buttonIndex;
            buttonIndex = Integer.toString(index);
            series1.getData().add(new XYChart.Data(buttonsClicks[index], buttonIndex));
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Winner");
        series2.getData().add(new XYChart.Data(win_clicks, "winrate"));

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }

    public static void showChart() {
        launch();
    }
}
