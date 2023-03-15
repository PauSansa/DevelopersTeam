package DeveloperTeam.Application;

import static org.junit.jupiter.api.Assertions.*;
class AskParameterTest {

    @org.junit.jupiter.api.Test
    void askInteger() {
    }

    @org.junit.jupiter.api.Test
    void askString() {
    }

    @org.junit.jupiter.api.Test
    void askFloat() {
    }


    @org.junit.jupiter.api.Test
    void askByte() {
    }

    @org.junit.jupiter.api.Test
    void askBoolean() {
    }

    @org.junit.jupiter.api.Test
    void askMaterial() {
        assertEquals("wood",AskParameter.askMaterial("write a wood or plastic"));
    }
}