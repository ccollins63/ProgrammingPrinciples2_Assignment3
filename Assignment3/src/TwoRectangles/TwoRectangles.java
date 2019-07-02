// Cameron Collins

package TwoRectangles;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoRectangles extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {   Scanner scan = new Scanner(System.in);

        int rectangle1XCoordinate, rectangle1YCoordinate, rectangle1Width, rectangle1Height,
                rectangle2XCoordinate, rectangle2YCoordinate, rectangle2Width, rectangle2Height;

        System.out.println("Enter the following.");
        System.out.println("Rectangle1 X Coordinate:");
        rectangle1XCoordinate = scan.nextInt();

        System.out.println("Rectangle1 Y Coordinate:");
        rectangle1YCoordinate = scan.nextInt();

        System.out.println("Rectangle1 width:");
        rectangle1Width = scan.nextInt();

        System.out.println("Rectangle1 height:");
        rectangle1Height = scan.nextInt();

        System.out.println("Rectangle2 X Coordinate:");
        rectangle2XCoordinate = scan.nextInt();

        System.out.println("Rectangle2 Y Coordinate:");
        rectangle2YCoordinate = scan.nextInt();

        System.out.println("Rectangle2 width:");
        rectangle2Width = scan.nextInt();

        System.out.println("Rectangle2 height:");
        rectangle2Height = scan.nextInt();

        Pane pane = new Pane();

        // Creates a rectangle with input coordinates
        Rectangle rectangle1 = new Rectangle(rectangle1XCoordinate, rectangle1YCoordinate, rectangle1Width, rectangle1Height);
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setStroke(Color.PURPLE);
        pane.getChildren().add(rectangle1);

        // Creates a rectangle with input coordinates
        Rectangle rectangle2 = new Rectangle(rectangle2XCoordinate, rectangle2YCoordinate, rectangle2Width, rectangle2Height);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.GREEN);
        pane.getChildren().add(rectangle2);

        if (contains(rectangle1, rectangle2) || contains(rectangle1, rectangle2))
        {
            Text contains = new Text(150, 450, "One rectangle is contained in another.");
            pane.getChildren().add(contains);
        }
        else if (overlapping(rectangle1, rectangle2))
        {
            Text overlapping = new Text(150, 450, "The rectangles overlap.");
            pane.getChildren().add(overlapping);
        }
        else
        {
            Text neither = new Text(150, 450, "The rectangles do not overlap.");
            pane.getChildren().add(neither);
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("TwoRectangles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method that sees if the rectangles are overlapping
    public boolean overlapping(Rectangle rectangle1, Rectangle rectangle2)
    {
        return getDistance(rectangle1.getX(), rectangle2.getX() + rectangle2.getWidth()) <
                rectangle1.getWidth() + rectangle2.getWidth() &&
                getDistance(rectangle1.getY(), rectangle2.getY() + rectangle2.getHeight()) <
                        rectangle1.getHeight() + rectangle2.getHeight();
    }

    // Method that sees if a rectangle is within another rectangle
    public boolean contains(Rectangle rectangle1, Rectangle rectangle2)
    {
        return rectangle2.getY() + rectangle2.getHeight() <= rectangle1.getY() + rectangle1.getHeight() &&
                        rectangle2.getX() + rectangle2.getWidth() <= rectangle2.getX() + rectangle1.getWidth() &&
                        rectangle2.getX() > rectangle1.getX() && rectangle2.getY() > rectangle1.getY();
    }

    // Method for distance between two points
    private double getDistance(double point1, double point2)
    {
        double distance = Math.sqrt(Math.pow(point2 - point1, 2));
        return distance;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
