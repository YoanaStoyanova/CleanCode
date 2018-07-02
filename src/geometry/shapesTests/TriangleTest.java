package geometry.shapesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geometry.shapes.Circle;
import geometry.shapes.Point;
import geometry.shapes.Triangle;

class TriangleTest {

	private Triangle tr;

	@BeforeEach
	public void initTriangle() {
		Point A = new Point(2.0, 1.0);
		Point B = new Point(6.0, 1.0);
		Point C = new Point(2.0, 4.0);

		tr = new Triangle(A, B, C);
	}

	@Test
	void ctor_givenPointOnSameLine_throwsIllegalArgumentException() {

		// Given
		Point A = new Point(0.0, 0.0);
		Point B = new Point(3.0, 0.0);
		Point C = new Point(7.0, 0.0);

		try {

			// When
			new Triangle(A, B, C);
			fail();

		} catch (IllegalArgumentException e) {

			// Then
			assertTrue(e.getMessage().matches("Points on same line"));
		}
	}

	@Test
	void ctor_givenSamePointMultipTimes_throwsIllegalArgumentException() {
		// Given
		Point A = new Point(4.0, 3.0);

		try {

			// When
			new Triangle(A, A, A);
			fail();

		} catch (IllegalArgumentException e) {

			// Then
			assertTrue(e.getMessage().matches("Points are not distinct"));
		}
	}

	@Test
	void getArea_givenValidTriangle_returnsArea() {

		// When
		Double area = tr.getArea();

		// Then
		assertEquals(6.0, area, 2);
	}

	@Test
	void getPerimeter_givenValidTriangle_returnsPerimeter() {

		// When
		Double perim = tr.getPerimeter();

		// Then
		assertEquals(12, perim, 2);
	}

	@Test
	void inShape_givenPointInTriangle_returnsTrue() {

		// Given
		Point p = new Point(3.0, 2.0);

		// When
		boolean inShape = tr.isInShape(p);

		// Then
		assertTrue(inShape);

	}

	@Test
	void inShape_givenPointOutOfTriangle_returnsFalse() {

		// Given
		Point p = new Point(40.0, 40.0);

		// When
		boolean inShape = tr.isInShape(p);

		// Then
		assertFalse(inShape);

	}

}
