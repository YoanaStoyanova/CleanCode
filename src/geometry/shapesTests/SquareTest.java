package geometry.shapesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geometry.shapes.Point;
import geometry.shapes.Rectangle;
import geometry.shapes.Square;

class SquareTest {

	Square square;

	@BeforeEach
	public void initRectangle() {
		Point lowerLeft = new Point(2.0, 2.0);
		Point upperRight = new Point(7.0, 7.0);
		square = new Square(lowerLeft, upperRight);
	}

	@Test
	void ctor_givenInvalidPoints_throwsIllegalArgumentException() {

		// Given
		Point lowerLeft = new Point(2.0, 2.0);
		Point upperRight = new Point(7.0, 4.0);

		try {

			// When
			new Square(lowerLeft, upperRight);
			fail();

		} catch (IllegalArgumentException e) {

			// Then
			assertTrue(e.getMessage().matches("Value of -?\\d+(.\\d+)? not equal to value of -?\\d+(.\\d+)?"));
		}

	}

	void ctor_givenPointsOnSameLine_throwsIllegalArgumentException() {
		// Given
		Point lowerLeft = new Point(2.0, 2.0);
		Point upperRight = new Point(7.0, 2.0);

		try {

			// When
			new Square(lowerLeft, upperRight);
			fail();

		} catch (IllegalArgumentException e) {

			// Then
			assertTrue(e.getMessage().matches("Value of -?\\d+(.\\d+)? not equal to value of -?\\d+(.\\d+)?"));
		}

	}

	@Test
	void getArea_givenValidSquare_ReturnsArea() {
		// When
		Double area = square.getArea();

		// Then
		assertEquals(25, area, 2);
	}

	@Test
	void getPerimeter_givenValidSquare_ReturnsPerimeter() {
		// When
		Double perim = square.getPerimeter();

		// Then
		assertEquals(20, perim, 2);
	}

	@Test
	void isInShape_givenPointInSqaure_ReturnsTrue() {
		// Given
		Point p = new Point(3.0, 4.0);

		// When
		boolean isInShape = square.isInShape(p);

		// Then
		assertTrue(isInShape);

	}

	@Test
	void isInShape_givenPointOutOfSquare_ReturnsFalse() {
		// Given
		Point p = new Point(12.0, 12.0);

		// When
		boolean isInShape = square.isInShape(p);

		// Then
		assertFalse(isInShape);

	}

}
