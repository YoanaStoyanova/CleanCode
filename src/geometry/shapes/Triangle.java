package geometry.shapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements Shape {

	private static int A = 0;
	private static int B = 1;
	private static int C = 2;
	private String shapeType = "Triangle";
	private Point[] points;
	private Double sideAB;
	private Double sideBC;
	private Double sideAC;

	public Triangle(Point A, Point B, Point C) {
		Double sideAB = Point.calcLineLength(A, B);
		Double sideBC = Point.calcLineLength(B, C);
		Double sideAC = Point.calcLineLength(A, C);
		validate(A, B, C);

		this.points = new Point[] { A, B, C };
		this.sideAB = sideAB;
		this.sideBC = sideBC;
		this.sideAC = sideAC;
		// System.out.println(this.shapeType + " Sides: " + sideAB + sideBC + sideAC);
		// for (Point p : points) {
		// System.out.print("< " + p.getX() + ", " + p.getY() + " > ");
		// }

	}

	@Override
	public double getArea() {
		Double halfPerim = this.getPerimeter() / 2;
		Double area = Math.sqrt(halfPerim * (halfPerim - sideAB) * (halfPerim - sideBC) * (halfPerim - sideAC));
		return area;
	}

	@Override
	public double getPerimeter() {
		return this.sideAB + this.sideBC + this.sideAC;
	}

	@Override
	public boolean isInShape(Point P) {

		Double areaAPC = new Triangle(points[A], P, points[C]).getArea();
		Double areaBPC = new Triangle(points[B], P, points[C]).getArea();
		Double areaAPB = new Triangle(points[A], P, points[B]).getArea();
		Double area = new BigDecimal(areaAPC + areaBPC + areaAPB).setScale(3, RoundingMode.HALF_EVEN).doubleValue();

		if (area.compareTo(this.getArea()) > 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String getShapeType() {
		return this.shapeType;
	}

	@Override
	public void translateShape(Double x, Double y) {
		for (Point p : this.points) {
			p.translatePoint(x, y);
		}
	}

	@Override
	public Circle circumscribedCircle() {
		Line bisectorAB = sideBisector(points[A], points[B]);
		Line bisectorBC = sideBisector(points[B], points[C]);
		Point center = bisectorAB.lineIntersection(bisectorBC);
		Double radius = Point.calcLineLength(center, points[A]);
		System.out.println(" Center " + center.getX() + " " + center.getY());
		return new Circle(center, radius);
	}

	private Line sideBisector(Point p1, Point p2) {
		Line lineAB = new Line(p1, p2);
		Point midAB = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
		return lineAB.perpendicLineInPoint(midAB);
	}

	@Override
	public void rotateShape(Double degree) {
		for (Point p : this.points) {
			p.rotatePoint(degree);
		}

	}

	private boolean validate(Point A, Point B, Point C) {

		if (A.equals(B) || B.equals(C) || C.equals(A)) {
			throw new IllegalArgumentException("Points are not distinct");
		} else {

			if (Point.onSameLine(new Point[] { A, B, C })) {
				throw new IllegalArgumentException("Points on same line");
			}
		}
		return true;
	}

}
