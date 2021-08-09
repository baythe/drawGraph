/**
 * 
 */
package drawGraph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author Yvonne
 *
 */
public class CanvasParabola extends Application{

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
		Canvas canvas = new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(600);
        drawSection(canvas);
        drawFunction(canvas);
        VBox vbox = new VBox(canvas);
        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Parabola in Canvas");
        primaryStage.show();
	}

	private void drawSection(Canvas canvas) {
		GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
		graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
		graphicsContext2D.strokeLine(0, 300, 600, 300);
        graphicsContext2D.strokeLine(300, 0, 300, 600);
	}
	
	private void drawFunction(Canvas canvas) {
		GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
		graphicsContext2D.setFill(Color.valueOf("#ff0000"));
		double y = 0;
		for (double x = -100; x<=100;x+=0.1) {
			y = x*x;
			graphicsContext2D.fillOval(300+x, 300-y, 2, 2);
		}
	}
}
