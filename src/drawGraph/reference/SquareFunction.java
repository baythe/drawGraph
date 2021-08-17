/**
 * 
 */
package drawGraph.reference;

/**
 * @author Yvonne
 *
 */
public class SquareFunction extends Graph {
	
	@Override
	double getY(double x) {
		// TODO Auto-generated method stub
		return (aValue*x*x) + (bValue*x) + cValue;
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return "y = "+aValue+"*x^2 + "+bValue+"*x + "+cValue;
	}

}
