package MoveCircle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class MoveCircle extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 500, 500);
        BallPane ballPane = new BallPane(250,250, 50);

        // Moves the circle up
        scene.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
            {
                ballPane.moveUp();
            }
        });

        // Moves the circle down
        scene.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.DOWN)
            {
                ballPane.moveDown();
            }
        });

        // Creates button that moves the circle left
        Button left = new Button("Left");
        left.setOnAction(e ->
        {
            ballPane.moveLeft();
        });

        // Creates button that moves the circle right
        Button right = new Button("Right");
        right.setOnAction(e ->
        {
            ballPane.moveRight();
        });

        // Sets the buttons at the bottom of window
        HBox buttons = new HBox(left, right);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));


        pane.setCenter(ballPane);
        pane.setBottom(buttons);

        primaryStage.setTitle("MoveBall");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class BallPane extends Pane {

        private Circle mCircle;

        public BallPane(double centerX, double centerY, double radius)
        {
            mCircle = new Circle(centerX, centerY, radius);
            getChildren().add(mCircle);
        }

        // Method to move circle up
        public void moveUp()
        {
            if (mCircle.getCenterY() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterY(mCircle.getCenterY() - (mCircle.getRadius() * 2));
        }

        // Method to move circle down
        public void moveDown()
        {
            if (mCircle.getCenterY() + mCircle.getRadius() + 10 > getHeight()) return;

            mCircle.setCenterY(mCircle.getCenterY() + (mCircle.getRadius() * 2));
        }

        // Method to move circle right
        public void moveRight()
        {
            if (mCircle.getCenterX() + mCircle.getRadius() + 10 > getWidth()) return;
            mCircle.setCenterX(mCircle.getCenterX() + (mCircle.getRadius() * 2));
        }

        // Method to move circle left
        public void moveLeft()
        {
            if (mCircle.getCenterX() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterX(mCircle.getCenterX() - (mCircle.getRadius() * 2));
        }

    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}