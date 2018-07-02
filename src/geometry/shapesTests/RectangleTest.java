package geometry.shapesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geometry.shapes.Point;
import geometry.shapes.Rectangle;

class RectangleTest {

	private Rectangle rect;

	@BeforeEach
	public void initRectangle() {
		Point lowerLeft = new Point(2.0, 2.0);
		Point upperRight = new Point(7.0, 8.0);
		rect = new Rectangle(lowerLeft, upperRight);
	}

	@Test
	void ctor_givenInvalidPoints_throwsIllegalArgumentException() {

		// Given
		Point lowerLeft = new Point(2.0, 2.0);
		Point upperRight = new Point(5.0, 2.0);

		try {
			// When
			new Rectangle(lowerLeft, upperRight);
			fail();

		} catch (IllegalArgumentException e) {
			// Then
			assertTrue(e.getMessage().matches("Value of arg -?\\d+(.\\d+)? is not less than value of -?\\d+(.\\d+)?"));
		}

	}

	@Test
	void getArea_givenValidRectangle_ReturnsArea() {
		// When
		Double area = rect.getArea();

		// Then
		assertEquals(30, area, 2);
	}

	@Test
	void getPerimeter_givenValidRectangle_ReturnsPerimeter() {
		// When
		Double perim = rect.getPerimeter();

		// Then
		assertEquals(22, perim, 2);
	}

	@Test
	void isInShape_givenPointInRectangle_ReturnsTrue() {
		// Given
		Point p = new Point(3.0, 4.0);

		// When
		boolean isInShape = rect.isInShape(p);

		// Then
		assertTrue(isInShape);

	}

	@Test
	void isInShape_givenPointOutOfRectangle_ReturnsFalse() {
		// Given
		Point p = new Point(12.0, 12.0);

		// When
		boolean isInShape = rect.isInShape(p);

		// Then
		assertFalse(isInShape);

	}

}
