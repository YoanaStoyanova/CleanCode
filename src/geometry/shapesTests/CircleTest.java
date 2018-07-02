package geometry.shapesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geometry.shapes.Circle;
import geometry.shapes.Point;

class CircleTest {

	private Point center;
	private Circle c;

	@BeforeEach
	public void initCenter() {
		center = new Point(0.0, 0.0);
		Double radius = 5.0;
		c = new Circle(center, radius);
	}

	@Test
	void ctor_givenNegativeRadius_throwsIndexOutOfBoundsException() {

		// Given
		Double radius = -4.0;

		try {

			// When
			new Circle(center, radius);
			fail();

		} catch (IndexOutOfBoundsException e) {

			// Then
			assertTrue(e.getMessage().matches("Negative argument value -\\d+(.\\d+)?"));
		}
	}

	@Test
	void getArea_givenValidCircle_returnsArea() {

		// Given - circle with radius 5.0
		
		// When
		Double area = c.getArea();

		// Then
		assertEquals(78.54, area, 2);
	}

	@Test
	void getPerimeter_givenValidCircle_returnsPerimeter() {

		// Given - circle with radius 5.0

		// When
		Double perim = c.getPerimeter();

		// Then
		assertEquals(31.42, perim, 2);
	}

	@Test
	void inShape_givenPointInCircle_returnsTrue() {

		// Given - circle with radius 5.0
		Point p = center;

		// When
		boolean inShape = c.isInShape(p);

		// Then
		assertTrue(inShape);

	}

	@Test
	void inShape_givenPointOutOfCircle_returnsFalse() {

		 // Given - circle with radius 5.0
		 Point p = new Point(40.0, 40.0);
		
		 // When
		 boolean inShape = c.isInShape(p);
		
		 // Then
		 assertFalse(inShape);

	}

}
