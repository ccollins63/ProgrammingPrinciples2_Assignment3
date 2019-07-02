// Cameron Collins

package SmileyFace;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SmileyFace extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        ArrayList<Node> shapes  = new ArrayList<>();

        // Creates the circle head
        Circle head             = new Circle(250, 250, 200);
        head.setFill(Color.TRANSPARENT);
        head.setStroke(Color.BLACK);
        shapes.add(head);

        // Creates the left eyeball
        Circle leftEyeBall      = new Circle(175, 150, 15);
        leftEyeBall.setFill(Color.BLACK);
        shapes.add(leftEyeBall);

        // Creates the right eyeball
        Circle rightEyeBall     = new Circle(325, 150, 15);
        rightEyeBall.setFill(Color.BLACK);
        shapes.add(rightEyeBall);

        // Creates the left eye
        Ellipse leftEye         = new Ellipse(175, 150, 40, 25);
        leftEye.setFill(Color.TRANSPARENT);
        leftEye.setStroke(Color.BLACK);
        shapes.add(leftEye);

        // Creates the right eye
        Ellipse rightEye        = new Ellipse(325, 150, 40, 25);
        rightEye.setFill(Color.TRANSPARENT);
        rightEye.setStroke(Color.BLACK);
        shapes.add(rightEye);

        // Creates the nose
        Polygon nose            = new Polygon(250, 200, 200, 300, 300, 300);
        nose.setFill(Color.TRANSPARENT);
        nose.setStroke(Color.BLACK);
        shapes.add(nose);

        // Creates the smile
        Arc smile = new Arc(
                head.getCenterX(), // center x
                head.getCenterY() + (head.getRadius() / 3), // center y
                head.getRadius() / 2, // x radius
                head.getRadius() / 2 / 2, // y radius
                180, 180); // start point and length
        smile.setFill(Color.TRANSPARENT);
        smile.setStroke(Color.BLACK);
        shapes.add(smile);

        pane.getChildren().addAll(shapes);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("SmileyFace");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
