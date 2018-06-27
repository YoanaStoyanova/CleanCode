
public interface Shape {

	public double getArea();

	public double getPerimeter();

	public boolean isInShape(Point p);

	public String getShapeType();

	public void translateShape(Double x, Double y);

	public Circle circumscribedCircle();

	public void rotateShape(Double degree);

}
