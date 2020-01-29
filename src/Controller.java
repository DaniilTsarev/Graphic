import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button button;
    public TextField textBox;
    @FXML
    public LineChart<Number, Number> graphic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphic.getStylesheets().add(Main.class.getResource("/image.css").toExternalForm());
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (double i = -20; i < 15; i += 0.5) {
            series.getData().add(new XYChart.Data(funcX(i), funcY(i)));
        }
        graphic.getData().add(series);
    }

    public void buttonClicked() {
        double number = Double.parseDouble(textBox.getCharacters().toString());
        XYChart.Series<Number,Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data(funcX(number),funcY(number)));
        series.getData().add(new XYChart.Data(funcX(number)-10,-0.1));
        series.getData().add(new XYChart.Data(funcX(number),0.5));
        series.getData().add(new XYChart.Data(funcX(number),-1.0));
        XYChart.Series<Number,Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data(funcX(number),funcY(number)));
        series1.getData().add(new XYChart.Data(funcX(number)-0.8,-1.0));

        graphic.getData().add(series);
        graphic.getData().add(series1);
    }

    private double funcX(double t) {
        return -2 * t - 2;
    }

    private double funcY(double t) {
        if ((t + 1) == 0) {
            return 0;
        } else {
            return -2 / (t + 1);
        }
    }
}
