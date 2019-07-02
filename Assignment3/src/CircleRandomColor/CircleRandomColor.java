// Cameron Collins

package CircleRandomColor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleRandomColor extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane( );

        Circle circle = new Circle(250, 250, 50);
        circle.setFill(getRandomColor());
        // Creates new circle of random color and location
        circle.setOnMousePressed(event ->
        {
            circle.setFill(getRandomColor());
            circle.setCenterX(Math.random() * (500 - 0) + 0);
            circle.setCenterY(Math.random() * (500 - 0) + 0);
        });

        pane.getChildren().addAll(circle);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("CircleRandomColor");
        primaryStage.setScene(scene);
        primaryStage.show( );
    }

    private Color getRandomColor()
    {
        return new Color(Math.random( ), Math.random( ), Math.random( ), Math.random( ));
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}