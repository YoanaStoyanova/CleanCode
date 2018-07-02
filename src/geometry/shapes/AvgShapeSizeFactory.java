package geometry.shapes;
import java.util.Random;

/**
 * Class generating random shapes of approximately similar size.
 * 
 * @author Joana
 *
 */
public class AvgShapeSizeFactory implements ShapeFactory {

	private static String[] shapes = { "CIRCLE", "TRIANGLE", "RECTANGLE", "SQUARE" };
	private int avgShapeSize = 3;
	private static int MAX_X_COORD = 50;
	private static int MAX_Y_COORD = 50;

	public void setAvgShapeSize(int size) {
		avgShapeSize = size;
	}

	@Override
	public Shape createShape() {
		Random chooseShapeType = new Random();
		String shapeType = shapes[chooseShapeType.nextInt(shapes.length)];
		Shape shape = constructShape(shapeType);
		return shape;
	}

	private Shape constructShape(String shapeType) {
		Shape shape = null;
		switch (shapeType) {
		case "CIRCLE":
			shape = constrRandomCircle();
			break;
		case "TRIANGLE":
			shape = constrRandomTriangle();
			break;
		case "SQUARE":
			shape = constrRandomSquare();
			break;
		case "RECTANGLE":
			shape = constrRandomRectangle();
			break;
		default:
			throw new IllegalArgumentException(shapeType + " is not a valid shape type");
		}

		return shape;
	}

	private Circle constrRandomCircle() {
		Random coordinates = new Random();
		Double X = (double) coordinates.nextInt(MAX_X_COORD);
		Double Y = (double) coordinates.nextInt(MAX_Y_COORD);

		Point center = new Point(X, Y);
		Double radius = Math.ceil(new Random().nextGaussian() + avgShapeSize);
		System.out.println("radius is: " + radius);
		return new Circle(center, radius);
	}

	private Square constrRandomSquare() {

		Double sidesLength = Math.ceil(new Random().nextGaussian() + avgShapeSize);
		Point lowerLeft = constrRandomPoint();
		Point upperRight = new Point(lowerLeft.getX() + sidesLength, lowerLeft.getY() + sidesLength);
		
		System.out.println("sidesLength is: " + sidesLength);
		return new Square(lowerLeft, upperRight);

	}

	private Rectangle constrRandomRectangle() {
		Double width = Math.ceil(new Random().nextGaussian() + avgShapeSize);
		Double height = Math.ceil(new Random().nextGaussian() + avgShapeSize);

		Point lowerLeft = constrRandomPoint();
		Point upperRight = new Point(lowerLeft.getX() + width, lowerLeft.getY() + height);
		System.out.println("sidesLength is: " + width + " " + height);
		return new Rectangle(lowerLeft, upperRight);

	}

	private Triangle constrRandomTriangle() {
		Double sideAB = Math.ceil(new Random().nextGaussian() + avgShapeSize);
		Double sideBC = Math.ceil(new Random().nextGaussian() + avgShapeSize);
		Point A = constrRandomPoint();
		Point B = new Point(A.getX() + sideAB, A.getY());
		Point C = new Point(B.getX(), B.getY() + sideBC);

		return new Triangle(A, B, C);
	}

	private Point constrRandomPoint() {
		Random coordinates = new Random();
		Double X = (double) coordinates.nextInt(MAX_X_COORD);
		Double Y = (double) coordinates.nextInt(MAX_Y_COORD);
		return new Point(X, Y);
	}

}
