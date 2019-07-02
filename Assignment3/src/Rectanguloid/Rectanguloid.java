// Cameron Collins

package Rectanguloid;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Rectanguloid extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        ArrayList<Node> shapes  = new ArrayList<>();

        // Creates a rectangle
        Rectangle rectangle1 = new Rectangle(0, 0);
        rectangle1.setX(100);
        rectangle1.setY(100);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.xProperty().bind(pane.widthProperty().divide(4).subtract(25));
        rectangle1.yProperty().bind(pane.heightProperty().divide(4).add(25));
        rectangle1.widthProperty().bind(pane.widthProperty().divide(4));
        rectangle1.heightProperty().bind(pane.heightProperty().divide(4));
        shapes.add(rectangle1);

        // Creates a rectangle
        Rectangle rectangle2 = new Rectangle(0, 0);
        rectangle2.setX(200);
        rectangle2.setY(200);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.xProperty().bind(pane.widthProperty().divide(4).add(25));
        rectangle2.yProperty().bind(pane.heightProperty().divide(4).subtract(25));
        rectangle2.widthProperty().bind(pane.widthProperty().divide(4));
        rectangle2.heightProperty().bind(pane.heightProperty().divide(4));
        shapes.add(rectangle2);

        // Creates line that connect the two rectangles
        Line line1 = new Line();
        line1.startXProperty().bind(rectangle1.xProperty());
        line1.startYProperty().bind(rectangle1.yProperty());
        line1.endXProperty().bind(rectangle2.xProperty());
        line1.endYProperty().bind(rectangle2.yProperty());
        shapes.add(line1);

        // Creates line that connect the two rectangles
        Line line2 = new Line();
        line2.startXProperty().bind(rectangle1.xProperty().add(rectangle1.widthProperty()));
        line2.startYProperty().bind(rectangle1.yProperty().add(rectangle1.heightProperty()));
        line2.endXProperty().bind(rectangle2.xProperty().add(rectangle1.widthProperty()));
        line2.endYProperty().bind(rectangle2.yProperty().add(rectangle1.heightProperty()));
        shapes.add(line2);

        // Creates line that connect the two rectangles
        Line line3 = new Line();
        line3.startXProperty().bind(rectangle1.xProperty());
        line3.startYProperty().bind(rectangle1.yProperty().add(rectangle1.heightProperty()));
        line3.endXProperty().bind(rectangle2.xProperty());
        line3.endYProperty().bind(rectangle2.yProperty().add(rectangle1.heightProperty()));
        shapes.add(line3);

        // Creates line that connect the two rectangles
        Line line4 = new Line();
        line4.startXProperty().bind(rectangle1.xProperty().add(rectangle1.widthProperty()));
        line4.startYProperty().bind(rectangle1.yProperty());
        line4.endXProperty().bind(rectangle2.xProperty().add(rectangle1.widthProperty()));
        line4.endYProperty().bind(rectangle2.yProperty());
        shapes.add(line4);

        pane.getChildren().addAll(shapes);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Rectanguloid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
