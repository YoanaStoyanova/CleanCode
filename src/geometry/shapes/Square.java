package geometry.shapes;

public class Square implements Shape {

	private static int lowerLeft = 0;
	private static int lowerRight = 1;
	private static int upperLeft = 2;
	private static int upperRight = 3;
	private String shapeType = "Square";
	private Point[] points;
	private Double sidesLength;

	public Square(Point lowerLeftPoint, Point upperRightPoint) {
		validate(lowerLeftPoint, upperRightPoint);

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
		return this.shapeType;
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

	private boolean validate(Point lowerLeft, Point upperRight) {
		Validators.less(lowerLeft.getX(), upperRight.getX());
		Validators.less(lowerLeft.getY(), upperRight.getY());
		Validators.areEqual(upperRight.getX() - lowerLeft.getX(), upperRight.getY() - lowerLeft.getY());

		return true;
	}

	@Override
	public void drawShape() {
		// stubbed method
		System.out.println("Drawing " + this.shapeType);

	}

}
