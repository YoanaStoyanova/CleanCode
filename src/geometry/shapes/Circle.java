package geometry.shapes;

public class Circle implements Shape {

	private Point center;
	private Double radius;
	private String shapeType = "Circle";

	public Circle(Point center, Double radius) {
		validate(center, radius);
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public boolean isInShape(Point p) {
		Double lengthTo = Point.calcLineLength(this.center, p);

		if (lengthTo <= this.radius) {
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
	public void translateShape(Double x, Double y) {
		this.center.translatePoint(x, y);
	}

	@Override
	public Circle circumscribedCircle() {
		return this;
	}

	@Override
	public void rotateShape(Double degree) {
		this.center.rotatePoint(degree);
	}

	private boolean validate(Point center, Double radius) {
		return Validators.positive(radius);
	}

	@Override
	public void drawShape() {
		//stubbed method
		System.out.println("Drawing " + this.shapeType);
		
	}

}
