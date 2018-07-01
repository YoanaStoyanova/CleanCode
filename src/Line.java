
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

	public Line perpendicLineInPoint(Point p) {
		if (isOnLine(p)) {
			Double c = -this.b * p.getX() + this.a * p.getY();
			return new Line(-this.b, this.a, c);
		} else {
			assert (false);
			return null;
		}
	}

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

	private boolean isOnLine(Point p) {
		assert (false);
		return true;
	}

}
