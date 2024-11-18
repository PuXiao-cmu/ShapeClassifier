import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Disabled;

public class ShapeClassifierTest {

    @DisplayName("Test: Line Correct Guess")
    @Test
    public void testLineCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Line,Small,No,5");
        assertEquals("Yes", answer);
    }

    @DisplayName("Test: Line Incorrect Guess")
    @Test
    public void testLineIncorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Circle,Small,No,5");
        assertNotEquals("Yes", answer);
        assertEquals("No: Suggestion=Line", answer);
    }

    @Disabled
    @DisplayName("Test: Circle Correct Guess")
    @Test
    public void testCircleCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Circle,Large,Yes,20,20");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Circle Incorrect Size Guess")
    @Test
    public void testCircleIncorrectSizeGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Circle,Small,Yes,20,20");
        assertEquals("Wrong Size", answer);
    }

    @Disabled
    @DisplayName("Test: Ellipse Correct Guess")
    @Test
    public void testEllipseCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Ellipse,Large,Yes,20,30");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Ellipse Incorrect Even/Odd Guess")
    @Test
    public void testEllipseIncorrectEvenOddGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Ellipse,Large,No,20,30");
        assertEquals("Wrong Even/Odd", answer);
    }

    @Disabled
    @DisplayName("Test: Rectangle Correct Guess")
    @Test
    public void testRectangleCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Rectangle,Large,Yes,10,20,10,20");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Rectangle Incorrect Guess")
    @Test
    public void testRectangleIncorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Square,Large,Yes,10,10,10,10");
        assertEquals("No: Suggestion=Square", answer);
    }

    @Disabled
    @DisplayName("Test: Square Correct Guess")
    @Test
    public void testSquareCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Square,Large,Yes,15,15,15,15");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Equilateral Triangle Correct Guess")
    @Test
    public void testTriangleEquilateralCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Equilateral,Large,Yes,30,30,30");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Isosceles Triangle Correct Guess")
    @Test
    public void testTriangleIsoscelesCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Isosceles,Large,Yes,30,30,10");
        assertEquals("Yes", answer);
    }

    @Disabled
    @DisplayName("Test: Scalene Triangle Correct Guess")
    @Test
    public void testTriangleScaleneCorrectGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Scalene,Large,No,30,20,10");
        assertEquals("Yes", answer);
    }

    @DisplayName("Test: Invalid Triangle Guess")
    @Test
    public void testTriangleInvalidGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Equilateral,Large,Yes,1,2,3");
        assertEquals("No: Suggestion=Not A Triangle", answer);
    }

    @DisplayName("Test: Too Many Bad Guesses")
    @Test
    public void testTooManyBadGuesses() {
        ShapeClassifier classifier = new ShapeClassifier();
        classifier.evaluateGuess("Circle,Small,No,10,20");
        classifier.evaluateGuess("Circle,Small,No,10,20");
        classifier.evaluateGuess("Circle,Small,No,10,20");
        // Expect the program to terminate or return an error state.
    }

    @DisplayName("Test: Invalid Input")
    @Test
    public void testInvalidInput() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Invalid,Input");
        assertEquals("No", answer);
    }

    @Disabled
    @DisplayName("Test: Negative Parameters")
    @Test
    public void testNegativeParameters() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Line,Small,No,-5");
        assertEquals("No: Suggestion=Line", answer);
    }

    @Disabled
    @DisplayName("Test: Parameters Exceed Limit")
    @Test
    public void testParametersExceedLimit() {
        ShapeClassifier classifier = new ShapeClassifier();
        String answer = classifier.evaluateGuess("Line,Small,No,5000");
        assertEquals("No: Suggestion=Line", answer);
    }
}
