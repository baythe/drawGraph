/**
 * 
 */
package drawGraph.reference;

import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class defines the interface (abstract class) for creating a graph. Each
 * graph will define the draw method and the formula being used.
 * 
 * @author Yvonne
 *
 */
public abstract class Graph {

	public static int scale = 15;
	public static double sectionSize = 600;
	public double aValue, bValue, cValue;

	abstract double getY(double x);
	public abstract String formula();

	public void setCoefficients(double a, double b, double c) {
		aValue = a;
		bValue = b;
		cValue = c;
	}

	public void draw(Canvas canvas) {
		GraphicsContext gc2D = canvas.getGraphicsContext2D();
		double mid = sectionSize/2;
		//gc2D.setFill(Color.valueOf("#ff0000"));
		gc2D.setFill(Color.rgb((new Random()).nextInt(255), (new Random()).nextInt(255), (new Random()).nextInt(255)));		
		for (double x =-100; x<=100;x+=0.01) {
			gc2D.fillOval(mid+(x*scale), mid-(getY(x)*scale), 2, 2);
		}
	}

}
