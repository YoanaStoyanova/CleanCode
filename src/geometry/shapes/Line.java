package geometry.shapes;

/**
 * This class represents a line by its equation
 * 
 * @author Joana
 *
 */
public class Line {

	private Double a;
	private Double b;
	private Double c;

	Line(Double a, Double b, Double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	Line(Point p1, Point p2) {
		assert (!p1.equals(p2));
		this.a = p1.getY() - p2.getY();
		this.b = p2.getX() - p1.getX();
		this.c = a * (p2.getX()) + b * (p2.getY());
	}

	/**
	 * Method calculates equation of new line perpendicular to current line in given
	 * point p.
	 * 
	 * @param p	is point on line
	 *            
	 * 
	 * @return perpendicular line
	 */
	public Line perpendicLineInPoint(Point p) {
		Double c = -this.b * p.getX() + this.a * p.getY();
		return new Line(-this.b, this.a, c);

	}

	/**
	 * Method calculates the point in which current line intersects with other line
	 * 
	 * @param other
	 * @return point of intersection
	 */
	public Point lineIntersection(Line other) {
		Double determinant = this.a * other.b - other.a * this.b;
		if (determinant == 0) {
			// lines are parallel
			return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
		} else {
			Double x = (other.b * this.c - this.b * other.c) / determinant;
			Double y = (this.a * other.c - other.a * this.c);
			return new Point(x, y);
		}
	}

}
