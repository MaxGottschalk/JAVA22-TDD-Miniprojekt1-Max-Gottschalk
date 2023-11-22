package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Triangle;

class TriangleTest {

	@Test
    @DisplayName("Testing input with length more than 3")
    public void getUserInputInputLength() {
        String[] arr = {"2", "2", "2", "2"};
        Triangle t = new Triangle(arr);
        assertNull(t.getCurrent_type());
    }
	
    @Test
    @DisplayName("Testing that the input type is correct")
    public void testingCorrectInputType() {
        String[] arr = {"a", "s", "d"};
        Triangle t = new Triangle(arr);
        assertNull(t.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test Triangle Creation from String Array")
    public void triangleString() {
    	String [] arr = {"3", "4", "5"};
    	Triangle triangle = new Triangle(arr);
    	
    	assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test Triangle Creation from Integers")
    public void triangleInt() {
    	Triangle t = new Triangle(3,4,5);
    	assertEquals(Triangle.TYPE.SCALENE, t.getCurrent_type());
    }
    
    @Test
    @DisplayName("Testing getUserInput with valid input")
    public void getUserInputValid() {
        String input = "3,4,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Triangle triangle = new Triangle();
        triangle.getUserInput();
        
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());

        System.setIn(System.in);
    }

    @Test
    @DisplayName("Testing getUserInput with invalid input")
    public void getUserInputInvalid() {
        String input = "*,y,p";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertNull(triangle.getCurrent_type());

        System.setIn(System.in);
    }

    @Test
    @DisplayName("Testing getUserInput with invalid input length")
    public void getUserInputLengthInvalid() {
        String input = "3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertNull(triangle.getCurrent_type());

        System.setIn(System.in);
    }

    
    //Set current test
    @Test
    @DisplayName("Equilateral Triangle Test")
    public void testEquilateralTriangle() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(3, 3, 3);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Isosceles Triangle Test")
    public void testIsoscelesTriangle() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(3, 3, 4);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Scalene Triangle Test")
    public void testScaleneTriangle() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Invalid Triangle - Sum of Two Sides Test")
    public void testInvalidTriangleSumOfTwoSides() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(2, 3, 6);
        assertNull(triangle.getCurrent_type());
    }

    //testing with a b or c as Zero
    @Test
    @DisplayName("Invalid Triangle - One Side Zero (Case A)")
    public void testInvalidTriangleOneSideZeroA() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(0, 3, 4);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Invalid Triangle - One Side Zero (Case B)")
    public void testInvalidTriangleOneSideZeroB() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(3, 0, 4);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Invalid Triangle - One Side Zero (Case C)")
    public void testInvalidTriangleOneSideZeroC() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(4, 3, 0);
        assertNull(triangle.getCurrent_type());
    }

    //Testing 2 equal sides 
    @Test
    @DisplayName("Invalid Triangle - Two Sides Equal, Sum of Two Sides (Case AB)")
    public void testInvalidTriangleTwoSidesEqualSumOfTwoSidesAB() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(2, 2, 5);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Invalid Triangle - Two Sides Equal, Sum of Two Sides (Case BC)")
    public void testInvalidTriangleTwoSidesEqualSumOfTwoSidesBC() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(5, 2, 2);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Invalid Triangle - Two Sides Equal, Sum of Two Sides (Case AC)")
    public void testInvalidTriangleTwoSidesEqualSumOfTwoSidesAC() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(2, 5, 2);
        assertNull(triangle.getCurrent_type());
    }
    
    //Test other variants of type isosceles 
    @Test
    @DisplayName("Equal Sum of Two Sides - BC")
    public void equalSumOfTwoSidesBC() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(3, 2, 2);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Equal Sum of Two Sides - AC")
    public void equalSumOfTwoSidesAC() {
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(2, 3, 2);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
}
