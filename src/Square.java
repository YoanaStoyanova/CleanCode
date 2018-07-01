
public class Square implements Shape {

	private static int lowerLeft = 0;
	private static int lowerRight = 1;
	private static int upperLeft = 2;
	private static int upperRight = 3;
	private String shapeName = "Square";
	private Point[] points;
	private Double sidesLength;

	Square(Point lowerLeftPoint, Point upperRightPoint) {
		assert (upperRightPoint.getX() - lowerLeftPoint.getX() == upperRightPoint.getY() - lowerLeftPoint.getY());
		assert (!lowerLeftPoint.equals(upperRightPoint));

		this.points = new Point[4];
		this.points[lowerLeft] = lowerLeftPoint;
		this.points[upperRight] = upperRightPoint;
		this.points[lowerRight] = new Point(upperRightPoint.getX(), lowerLeftPoint.getY());
		this.points[upperLeft] = new Point(lowerLeftPoint.getX(), upperRightPoint.getY());

		this.sidesLength = this.points[lowerRight].getX() - this.points[lowerLeft].getX();
	}

	@Override
	public double getArea() {
		return this.sidesLength * this.sidesLength;
	}

	@Override
	public double getPerimeter() {
		return 4 * this.sidesLength;
	}

	@Override
	public boolean isInShape(Point p) {

		if (p.getX() >= this.points[lowerLeft].getX() && p.getX() <= this.points[upperRight].getX()
				&& p.getY() >= this.points[lowerLeft].getY() && p.getY() <= this.points[upperRight].getY()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getShapeType() {
		return this.shapeName;
	}

	@Override
	public Circle circumscribedCircle() {
		Double centerX = (this.points[lowerLeft].getX() + this.points[upperRight].getX()) / 2;
		Double centerY = (this.points[lowerLeft].getY() + this.points[upperRight].getY()) / 2;
		Point center = new Point(centerX, centerY);
		Double radius = Point.calcLineLength(this.points[lowerLeft], center);
		return new Circle(center, radius);

	}

	@Override
	public void translateShape(Double x, Double y) {
		for (Point p : this.points) {
			p.translatePoint(x, y);
		}
	}

	@Override
	public void rotateShape(Double degree) {
		for (Point p : this.points) {
			p.rotatePoint(degree);
		}
	}

}
