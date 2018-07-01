import java.util.Random;

public class AvgShapeSizeFactory implements ShapeFactory {

	private static String[] shapes = { "CIRLCE", "TRIANGLE", "RECTANGLE", "SQUARE" };
	private static int avgShapeSize = 3;
	private static int MAX_X_COORD = 50;
	private static int MAX_Y_COORD = 50;

	public static void setAvgShapeSize(int size) {
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
		Double radius = coordinates.nextGaussian() + avgShapeSize;
		return new Circle(center, radius);
	}

	private Square constrRandomSquare() {

		Double sideLength = new Random().nextGaussian() + avgShapeSize;
		Point lowerLeft = constrRandomPoint();
		Point upperRight = new Point(lowerLeft.getX() + sideLength, lowerLeft.getY() + sideLength);

		return new Square(lowerLeft, upperRight);

	}

	private Rectangle constrRandomRectangle() {
		Double width = new Random().nextGaussian() + avgShapeSize;
		Double height = new Random().nextGaussian() + avgShapeSize;

		Point lowerLeft = constrRandomPoint();
		Point upperRight = new Point(lowerLeft.getX() + width, lowerLeft.getY() + height);

		return new Rectangle(lowerLeft, upperRight);

	}

	private Triangle constrRandomTriangle() {
		Double sideAB = new Random().nextGaussian() + avgShapeSize;
		Double sideBC = new Random().nextGaussian() + avgShapeSize;
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
