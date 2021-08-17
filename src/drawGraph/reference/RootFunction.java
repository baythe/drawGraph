/**
 * 
 */
package drawGraph.reference;

import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class will chart the cubic function
 * f(x) = ax3 + bx2 + cx + d
 * @author Yvonne
 *
 */
public class RootFunction extends Graph {

	@Override
	double getY(double x) {
		if (aValue*x > bValue)
			return Math.sqrt((aValue*x)+bValue)+cValue;
		return 0;
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return "y = sqrt(ax + b) + c";
	}

	public void draw(Canvas canvas) {
		GraphicsContext gc2D = canvas.getGraphicsContext2D();
		double mid = sectionSize/2;
		//gc2D.setFill(Color.valueOf("#ff0000"));
		gc2D.setFill(Color.rgb((new Random()).nextInt(255), (new Random()).nextInt(255), (new Random()).nextInt(255)));		
		for (double x =-100; x<=100;x+=0.01) {
			double y = getY(x);
			if (y != 0)
				gc2D.fillOval(mid+(x*scale), mid-(y*scale), 2, 2);
		}
	}
}
