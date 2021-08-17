/**
 * 
 */
package drawGraph;

import drawGraph.reference.Graph;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This program will propose several graphs options to the user. Once the user
 * choose the function to draw, the program will display the function pattern
 * and draw the graph selected with the existing inputs.
 * 
 * @author Yvonne
 *
 */
public class CommonFunctions extends Application {

	TextField A, B, C;
	Canvas canvas, frame;
	int scale = Graph.scale;
	Label footer = new Label("The function formula will be displayed HERE");
	double sectionSize = Graph.sectionSize;
	String GraphType;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define the borderpane which will contain all the nodes
		BorderPane bp = new BorderPane();
		addTopLayer(bp);
		addCanvasCenter(bp);
		addLeftMenu(bp);
		bp.setBottom(footer);
		Scene scene = new Scene(bp, 750, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Draw Functions in Canvas");
		drawSection();
		primaryStage.show();
	}

	public void addTopLayer(BorderPane bp) {
		// --------------- Elements in top panel -----------------
		// Define top elements
		A = new TextField();
		B = new TextField();
		C = new TextField();
		Button draw = new Button("DRAW");
		draw.setStyle("-fx-text-fill : white; -fx-background-color: blue;");
		draw.setOnAction(e -> {
			drawFunction();
		});
		Button clear = new Button("CLEAR");
		clear.setStyle("-fx-text-fill : white; -fx-background-color: gray;");
		clear.setOnAction(e -> {
			canvas.getGraphicsContext2D().clearRect(0, 0, sectionSize, sectionSize);
		});

		HBox hbox = new HBox(10, new Label("a:"), A, new Label("b:"), B, new Label("c:"), C, draw, clear);
		hbox.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		bp.setTop(hbox);
	}

	public void addCanvasCenter(BorderPane bp) {
		// Define the canvas in center panel.
		canvas = new Canvas(sectionSize, sectionSize);

		// Define the canvas which will contain the graph frame
		frame = new Canvas(sectionSize, sectionSize);
		// Adding canvas in a Panel
		Pane pane = new Pane(frame, canvas);
		canvas.toFront();
		bp.setCenter(pane);
		BorderPane.setAlignment(pane, Pos.CENTER);
		bp.setPadding(new Insets(10));
		BorderPane.setMargin(pane, new Insets(10));
	}

	public void addLeftMenu(BorderPane bp) {
		Label label = new Label("Math Functions");
		RadioButton rb1 = new RadioButton("Linear");
		RadioButton rb2 = new RadioButton("Square");
		RadioButton rb3 = new RadioButton("Square Root");
		RadioButton rb4 = new RadioButton("Sine");

		ToggleGroup rGrp = new ToggleGroup();

		rb1.setToggleGroup(rGrp);
		rb2.setToggleGroup(rGrp);
		rb3.setToggleGroup(rGrp);
		rb4.setToggleGroup(rGrp);
		rb1.setSelected(true);
		GraphType = "linear";

		rGrp.selectedToggleProperty().addListener((e, ov, nv) -> {
			RadioButton rb = (RadioButton) rGrp.getSelectedToggle();
			if (rb != null) {
				GraphType =rb.getText();
			}
		});

		VBox vbox = new VBox(label, rb1, rb2, rb3, rb4);
		// vbox.setMinSize(50, 100);
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(5));
		vbox.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, null, null)));
		vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		bp.setLeft(vbox);
	}

	public void drawFunction() {
		Graph graph = (new GraphFactory()).getGraph(GraphType);
		graph.setCoefficients(getNumber(A), getNumber(B), getNumber(C));
		graph.draw(canvas);
		footer.setText(graph.formula());
	}

	private double getNumber(TextField c2) {
		double value = 0;
		try {
			value = Double.valueOf(c2.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
		return value;
	}

	public void drawSection() {
		GraphicsContext gc2D = frame.getGraphicsContext2D();
		gc2D.setStroke(Color.valueOf("#0000ff"));

		double middle = sectionSize / 2;
		gc2D.strokeLine(0, middle, sectionSize, middle);
		gc2D.strokeLine(middle, 0, middle, sectionSize);
		for (int i = scale; i < sectionSize; i += scale) {
			gc2D.strokeLine(i, middle - 2, i, middle + 2);
			gc2D.strokeLine(middle - 2, i, middle + 2, i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
