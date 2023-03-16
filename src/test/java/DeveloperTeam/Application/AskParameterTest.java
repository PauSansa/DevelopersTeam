package DeveloperTeam.Application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AskParameterTest {

    @Test
    void askIntegerTest() {
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int expected = 10;
        int actual = AskParameter.askInteger("Enter an integer: ");
        assertEquals(expected, actual);
    }

    @Test
    void AskIntegerTestNonIntegerInput() {
        String input = "not an integer\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int expected = 10;
        int actual = AskParameter.askInteger("Enter an integer: ");
        assertEquals(expected, actual);
    }

    @Test
    void askIntegerTestRange() {
        // Arrange
        String input = "5\n";
        int expected = 5;
        // Act
        int result = AskParameter.askIntegerRange("Enter an integer between 1 and 10: ", 1, 10);
        // Assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void testInvalidIntegerRange() {
        // Arrange
        String input = "15\n5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int minNumber= 0;
        int  maxNumber=10;
        // Act
        int result = AskParameter.askIntegerRange("Enter an integer between " + minNumber + " and " + maxNumber + ":", minNumber, maxNumber);
        // Assert
        Assertions.assertTrue(result < minNumber || result > maxNumber);
    }

    @Test
    void askString() {
        // Prepare input
        String input = "Hello World!";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call method and check output
        assertEquals("hello world!", AskParameter.askString("Enter a string:"));
    }

    @Test
    void askFloat() {
        String input = "3.1416\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        float result = AskParameter.askFloat("Enter a float: ");
        Assertions.assertEquals(3.14f, result);
    }

    @Test
    void AskFloatTestNonIntegerInput() {

        float expected = 3.14f;
        String input = "invalid input\n-123.456\n3.14";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        float actual = AskParameter.askFloat("Enter a float value: ");
        assertEquals(expected, actual);

    }


    @Test
    void askByte() {
    }

    @Test
    void askBoolean() {
    }

    @Test
    void askMaterialTest() {
        String message = "Please enter the material type: wood or plastic";
        String input = "metal\nwood\n";
        String expected = "wood";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String actual = AskParameter.askMaterial(message);
        assertEquals(expected, actual);
    }

    @BeforeEach
    void setUp() {
    }


}