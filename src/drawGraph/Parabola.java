/**
 * 
 */
package drawGraph;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author Yvonne
 *
 */
public class Parabola extends Application{

	Stage window;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Display a parabola");
		Scene scene = new Scene(new Pane(), 600, 600);
		drawSection(scene);
		drawfunction(scene);
		window.setScene(scene);
		window.show();
	}
	
	public void drawSection(Scene scene) {
		Line line1 = new Line(0, 300, 600, 300);
		Line line2 = new Line(300, 0, 300, 600);
		Pane pane = (Pane) scene.getRoot();
		pane.getChildren().add(line1);
		pane.getChildren().add(line2);
	}
	
	/**
	 * This method will draw a parabola. for instance, y=x^2 or y=ax^2+bx+c
	 * @param scene
	 */
	public void drawfunction(Scene scene) {
		Pane pane = (Pane) scene.getRoot();
		List<Point2D> points = new ArrayList<Point2D>();
		double y = 0;
		for (double x = -100; x<=100;x+=0.1) {
			y = x*x;
			Circle circle = new Circle(x+300, 300-y,2);
			circle.setFill(Color.RED);
			pane.getChildren().add(circle);
		}
	}


}
