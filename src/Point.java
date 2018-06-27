
public class Point {
	private Double x;
	private Double y;

	Point() {
		this.x = this.y = 0.0;
	}

	Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	void setX(Double x) {
		this.x = x;
	}

	Double getX() {
		return this.x;
	}

	void setY(Double y) {
		this.y = y;
	}

	Double getY() {
		return this.y;
	} 
	
	public void translatePoint(Double x, Double y) {
		this.x += x;
		this.y += y;
	}
	
	public void rotatePoint(Double degree) {
		this.x = this.x * Math.cos(Math.toRadians(degree)) - this.y * Math.sin(Math.toRadians(degree));
		this.y = this.x * Math.sin(Math.toRadians(degree)) + this.y * Math.cos(Math.toRadians(degree));
	}
	
	public static Double calcLineLength(Point p1, Point p2) {
		return Math.sqrt(
				(p2.getX() - p1.getX()) * (p2.getX() - p1.getX()) + (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()));
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
