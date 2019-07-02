// Cameron Collins

package Grid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Grid extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane( );

        double divider = 3;
        // Creates red vertical lines
        for (int i = 0; i < 2; i++)
        {
            Line line = new Line();
            line.setStroke(Color.RED);
            line.startXProperty().bind(pane.widthProperty().divide(divider));
            line.startYProperty().bind(pane.layoutYProperty());
            line.endXProperty().bind(line.startXProperty());
            line.endYProperty().bind(pane.heightProperty());
            pane.getChildren().add(line);
            divider /= 2;
        }

        divider = 3;
        // Creates blue horizontal lines
        for (int i = 0; i < 2; i++)
        {
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.startXProperty().bind(pane.layoutXProperty());
            line.startYProperty().bind(pane.heightProperty().divide(divider));
            line.endXProperty().bind(pane.widthProperty());
            line.endYProperty().bind(pane.heightProperty().divide(divider));
            pane.getChildren().add(line);
            divider /= 2;
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("3 x 3 Grid");
        primaryStage.setScene(scene);
        primaryStage.show( );
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
