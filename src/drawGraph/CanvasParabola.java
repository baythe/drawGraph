/**
 * 
 */
package drawGraph;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Yvonne
 *
 */
public class CanvasParabola extends Application{

	TextField A,B,C;
	double aValue, bValue, cValue;
	int scale = 25;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define the canvas on which the mathematical graph will be drawn
		Canvas canvas = new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(600);
        
        //Define the canvas which will contain the graph frame
        Canvas frame = new Canvas(600, 600);
        drawSection(frame);
        
        //Adding canvas in a Panel
        Pane pane = new Pane(frame,canvas);
        canvas.toFront();
        
        // Define the textfields
        A = new TextField();
        B = new TextField();
        C = new TextField();
        Button drawButton = new Button("DRAW");
        drawButton.setStyle("-fx-text-fill : white; -fx-background-color: red;");
        drawButton.setOnAction( e -> {
        	retrieveInput();
        	canvas.getGraphicsContext2D().clearRect(0, 0, 600, 600);
        	//drawSection(canvas);
            drawFunction(canvas);
        });
        
        HBox hbox = new HBox(10, new Label("a:"),A,new Label("b:"),B,new Label("c:"),C,drawButton);
        hbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        
        //Add The panels into a VBOX layout
        VBox vbox = new VBox(hbox,pane);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(5));
        vbox.setMargin(pane, new Insets(5));
        Scene scene = new Scene(vbox, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display Parabola in Canvas");
        primaryStage.show();
	}

	private void retrieveInput() {
		aValue = getNumber(A);
		bValue = getNumber(B);
		cValue = getNumber(C);
	}
	
	private void drawSection(Canvas canvas) {
		GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
		graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
		graphicsContext2D.strokeLine(0, 300, 600, 300);
        graphicsContext2D.strokeLine(300, 0, 300, 600);
        for (int i=scale;i<600;i+=scale) {
        	graphicsContext2D.strokeLine(i,295,i,305);
        	graphicsContext2D.strokeLine(295,i,305,i);
        }
	}
	
	private void drawFunction(Canvas canvas) {
		GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
		graphicsContext2D.setFill(Color.valueOf("#ff0000"));
		double y = 0;
		for (double x =-100; x<=100;x+=0.01) {
			y = (aValue*x*x) + (bValue*x) + cValue;
			graphicsContext2D.fillOval(300+x*scale, 300-(y*scale), 2, 2);
		}
	}
	
	private double getNumber(TextField textfield) {
		double value = 0;
		try {
			value = Double.valueOf(textfield.getText());
		}catch(NumberFormatException e) {
			value = 0;
		}
		return value;
	}
}
