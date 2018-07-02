package geometry.shapesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geometry.shapes.Point;

class PointTest {

	Point p;

	@BeforeEach
	public void initPoint() {
		p = new Point(3.0, 4.0);
	}

	@Test
	void rotatePoint_givenPoint_changesCoordinates() {
		// Given
		Double degree = 30.0;

		// When
		p.rotatePoint(degree);

		// Then
		assertEquals(0.59, p.getX(), 2);
		assertEquals(4.96, p.getY(), 2);
	}

	@Test
	void translatePoint_givenPoint_changesCoordinates() {
		// Given
		Double translateX = 3.0;
		Double translateY = -6.0;

		// When
		p.translatePoint(translateX, translateY);

		// Then
		assertEquals(6.0, p.getX(), 2);
		assertEquals(-2.0, p.getY(), 2);
	}

	@Test
	void calcLineLength_givenTwoPoints_returnsLengthBetween() {
		// Given
		Point p1 = p;
		Point p2 = new Point(10.0, -6.5);

		// When
		Double lineLength = Point.calcLineLength(p1, p2);

		// Then
		assertEquals(12.61, lineLength, 2);
	}

	@Test
	void onSameLine_givenPointsOnSameHorizontalLine_returnsTrue() {
		// Given
		Point p1 = new Point(3.0, 4.0);
		Point p2 = new Point(10.0, 4.0);

		// When
		boolean onSameLine = Point.onSameLine(new Point[] { p1, p2 });

		// Then
		assertTrue(onSameLine);

	}

	@Test
	void onSameLine_givenPointsOnSameVerticalLine_returnsTrue() {
		// Given
		Point p1 = new Point(4.0, 3.0);
		Point p2 = new Point(4.0, 10.0);

		// When
		boolean onSameLine = Point.onSameLine(new Point[] { p1, p2 });

		// Then
		assertTrue(onSameLine);

	}
	
	@Test
	void onSameLine_givenPointsNotOnSamelLine_returnsTrue() {
		//Given
		Point p1 = new Point(3.0,6.0);
		Point p2 = new Point(10.0,4.0);
		
		//When
		boolean onSameLine = Point.onSameLine(new Point[] {p1,p2});
		
		//Then
		assertFalse(onSameLine);
		
	}

}
