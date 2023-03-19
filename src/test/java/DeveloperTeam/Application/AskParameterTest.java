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
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int expected = 5;
        // Act
        int result = AskParameter.askIntegerRange("Enter an integer between 1 and 10: ", 1, 10);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void InvalidIntegerRangeTest() {
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
    void askStringTest() {
        // Prepare input
        String input = "Hello World!";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Call method and check output
        assertEquals("hello world!", AskParameter.askString("Enter a string:"));
    }

    @Test
    void askFloatTest() {
        String input = "3.1416\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        float expectedOutput = 3.14f; // expected output
        float result = AskParameter.askFloat("Enter a float: ");
        Assertions.assertEquals(expectedOutput, result);
    }

    /*@Test
    void AskFloatTestNonIntegerInput() {


        String input = "invalid input\n-123.456\n3.14";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        float expected = 3.14f;
        float actual = AskParameter.askFloat("Enter a float value: ");
        assertEquals(expected, actual);
    }*/


    @Test
    void askByteRangeTest() {
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        byte result = AskParameter.askByteRange("Enter a byte between 0 and 100: ", 0, 100);
        byte expectedOutput =10; // expected output
        assertEquals(expectedOutput, result);
    }


    @Test
    void askByteRangeInvalidInputTest() {
        String input = "hello\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        byte result = AskParameter.askByteRange("Enter a byte between 1 and 10: ", 1, 10);
        byte expectedOutput = 2; // expected output
        Assertions.assertEquals(expectedOutput, result);
    }
    @Test
    void askBoolean() {
    }

    @Test
    void askMaterialTest() {

        // Arrange
        String message = "Please enter the material type: wood or plastic";
        String input = "wood\n";
        String expected = "wood";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Act
        String actual = AskParameter.askMaterial(message);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void AskMaterialInvalidInputTest() {
        // Arrange
        String input = "metal\nplastic\n";
        String expected = "plastic";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Act
        String result = AskParameter.askMaterial("Enter a material (wood or plastic): ");
        // Assert
        Assertions.assertEquals(expected, result);
    }
}