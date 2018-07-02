package geometry.shapes;

public class Point {
	private Double x;
	private Double y;

	Point() {
		this.x = this.y = 0.0;
	}

	public Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getX() {
		return this.x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getY() {
		return this.y;
	}

	public void translatePoint(Double x, Double y) {
		this.x += x;
		this.y += y;
	}

	public void rotatePoint(Double degree) {
		Double temp = this.x * Math.cos(Math.toRadians(degree)) - this.y * Math.sin(Math.toRadians(degree));
		this.y = this.x * Math.sin(Math.toRadians(degree)) + this.y * Math.cos(Math.toRadians(degree));
		this.x = temp;
	}

	public static Double calcLineLength(Point p1, Point p2) {
		return Math.sqrt(
				(p2.getX() - p1.getX()) * (p2.getX() - p1.getX()) + (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()));
	}

	public static boolean onSameLine(Point[] points) {
		boolean verticalLine = true;
		boolean horizontalLine = true;
		for (int i = 0; i < points.length - 1; ++i) {
			if (points[i].x.compareTo(points[i + 1].x) != 0) {
				verticalLine = false;
			}

			if (points[i].y.compareTo(points[i + 1].y) != 0) {
				horizontalLine = false;
			}

			if (!verticalLine && !horizontalLine) {
				break;
			}
		}

		return (verticalLine || horizontalLine);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

}
