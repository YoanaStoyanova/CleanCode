package geometry.shapes;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
//		Rectangle r = new Rectangle(new Point(1.0, 2.0), new Point(4.0, 4.0));
//		System.out.println();
//		r.rotateShape(43.0);
//		System.out.println(r.isInShape(new Point(-3.0, 2.0)));
//		Random rn = new Random();
//		System.out.println(rn.nextInt(10));
//		AvgShapeSizeFactory fact = new AvgShapeSizeFactory();
//		fact.setAvgShapeSize(4);
//		fact.createShape();
//		Circle c = new Circle(new Point(0.0,0.0),4.0);
//		System.out.println("\n\n");
//		System.out.println(new Random().nextGaussian()+5);
		Point A = new Point(2.0, 1.0);
		Point B = new Point(6.0, 1.0);
		Point C = new Point(2.0, 4.0);

		Triangle tr = new Triangle(A, B, C);
		System.out.println(tr.circumscribedCircle().getArea());
		
	}

}
