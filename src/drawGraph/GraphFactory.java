/**
 * 
 */
package drawGraph;

import drawGraph.reference.Graph;
import drawGraph.reference.LinearFunction;
import drawGraph.reference.RootFunction;
import drawGraph.reference.SquareFunction;

/**
 * This class return an Graph object depending on the function Type
 * @author Yvonne
 *
 */
public class GraphFactory {
	
	public Graph getGraph(String functionType) {
		if (functionType.equalsIgnoreCase("linear")) {
			return new LinearFunction();
		}else if (functionType.equalsIgnoreCase("Square Root")) {
			return new RootFunction();
		}else
			return new SquareFunction();
	}

}
