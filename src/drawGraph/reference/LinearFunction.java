/**
 * 
 */
package drawGraph.reference;

/**
 * @author Yvonne
 *
 */
public class LinearFunction extends Graph {


	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return "y = "+aValue+"*x + "+bValue;
	}

	@Override
	double getY(double x) {
		// TODO Auto-generated method stub
		return (aValue*x) + bValue;
	}

}
