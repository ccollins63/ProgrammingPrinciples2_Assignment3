// Cameron Collins

package Airplane;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Airplane extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane( );

        ImageView background = new ImageView("http://m5.i.pbase.com/v3/62/511062/2/50100865.IMG_0612_Krajobraz.jpg");
        // Creates plane image and sets the size
        Image image = new Image("http://freepngimages.com/wp-content/uploads/2015/05/tornado-jet-plane.png");
        ImageView plane = new ImageView(image);
        plane.setFitHeight(50);
        plane.setFitWidth(100);
        plane.setX(0);
        plane.setY(20);

        // Sets up the path
        PathTransition pathTransition = new PathTransition(Duration.millis(10000),
                new Line(plane.getX(), plane.getY(), 500, 500), plane);
        pathTransition.setCycleCount(1);

        //Start button
        Button start = new Button("Start");
        start.setLayoutX(200);
        start.setOnAction(event ->
        {
            pathTransition.play();
        });

        //Stop button
        Button stop = new Button("Stop");
        stop.setLayoutX(250);
        stop.setOnAction(event ->
        {
            pathTransition.stop();
        });

        pane.getChildren().addAll(background, plane, start, stop);
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Airplane");
        primaryStage.setScene(scene);
        primaryStage.show( );
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
