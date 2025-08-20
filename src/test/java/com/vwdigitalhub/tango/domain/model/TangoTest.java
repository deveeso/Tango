package com.vwdigitalhub.tango.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TangoTest {

    private Workspace workspace;

    @BeforeEach
    void setUp() {
        workspace = new Workspace(50, 50);
    }

    // --- Constructor and Getters Tests ---

    @Test
    @DisplayName("Constructor should set initial position and orientation")
    void constructorShouldSetInitialState() {
        // Given
        Position initialPosition = new Position(10, 23);
        Orientation initialOrientation = Orientation.N;
        // When
        Tango tango = new Tango(initialPosition, initialOrientation, workspace);
        // Then
        assertThat(tango.getPosition()).isEqualTo(initialPosition);
        assertThat(tango.getOrientation()).isEqualTo(initialOrientation);
    }

    @Test
    @DisplayName("Constructor should throw an exception if the initial position is invalid")
    void constructorShouldThrowExceptionIfInitialPositionIsInvalid() {
        // Given an invalid position (outside workspace boundaries)
        Position position = new Position(50, 51);
        // When trying to create a Tango robot, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Tango(position, Orientation.N, workspace);
        });
    }

    // --- Load and execute instructions tests ---

    @Test
    @DisplayName("Should correctly execute a sequence of instructions. Example 1")
    void shouldExecuteInstructionsCorrectly1() {
        // Given valid initialisation and instructions
        Tango tango = new Tango(new Position(1, 2), Orientation.N, workspace);
        tango.loadInstructions("LMLMLMLMM");
        // When executing the instructions
        tango.executeInstructions();
        // Then
        assertThat(tango.getPosition()).isEqualTo(new Position(1, 3));
        assertThat(tango.getOrientation()).isEqualTo(Orientation.N);
        assertThat(tango).hasToString("1 3 N");
    }

    @Test
    @DisplayName("Should correctly execute a sequence of instructions. Example 2")
    void shouldExecuteInstructionsCorrectly2() {
        // Given valid initialisation and instructions
        Tango tango = new Tango(new Position(3, 3), Orientation.E, workspace);
        tango.loadInstructions("MMRMMRMRRM");
        // When executing the instructions
        tango.executeInstructions();
        // Then
        assertThat(tango.getPosition()).isEqualTo(new Position(5, 1));
        assertThat(tango.getOrientation()).isEqualTo(Orientation.E);
        assertThat(tango).hasToString("5 1 E");
    }

    @Test
    @DisplayName("Should correctly execute a sequence of instructions. Example 3")
    void shouldExecuteInstructionsCorrectly3() {
        // Given valid initialisation and instructions
        Tango tango = new Tango(new Position(34, 43), Orientation.E, workspace);
        tango.loadInstructions("LMMRMLMRMLRRM");
        // When executing the instructions
        tango.executeInstructions();
        // Then
        assertThat(tango.getPosition()).isEqualTo(new Position(36, 45));
        assertThat(tango.getOrientation()).isEqualTo(Orientation.S);
        assertThat(tango).hasToString("36 45 S");
    }

    @Test
    @DisplayName("Should throw an exception if a robot moves to an occupied position")
    void shouldThrowExceptionWhenMovingToOccupiedPosition() {
        // Given a 1st Tango robot at (1, 3)
        new Tango(new Position(1, 3), Orientation.N, workspace);
        // and a 2nd Tango robot at (1, 2) that will try to move to (1, 3)
        Tango collidingTango = new Tango(new Position(1, 2), Orientation.N, workspace);
        collidingTango.loadInstructions("M");
        // When it tries to execute its instructions, it should throw an exception
        assertThrows(IllegalArgumentException.class, collidingTango::executeInstructions);
    }

    @Test
    @DisplayName("Should throw an exception if a robot moves outside the workspace boundaries")
    void shouldThrowExceptionWhenMovingOutsideBoundaries() {
        // Given a Tango robot already at the edge of the workspace (50, 50)
        Tango tango = new Tango(new Position(50, 50), Orientation.N, workspace);
        tango.loadInstructions("M");
        // When it tries to move forward, it should throw an exception
        assertThrows(IllegalArgumentException.class, tango::executeInstructions);
    }

    @Test
    @DisplayName("Should throw an exception if an invalid instruction is loaded")
    void shouldThrowExceptionForInvalidInstruction() {
        // Given a Tango robot
        Tango tango = new Tango(new Position(1, 2), Orientation.N, workspace);
        // When it tries to load an invalid instruction, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            tango.loadInstructions("X");
        });
    }

    // --- toString() Tests ---

    @Test
    @DisplayName("Should return the position and orientation in a formatted string")
    void shouldReturnFormattedString() {
        Tango tango = new Tango(new Position(15, 2), Orientation.W, workspace);
        assertThat(tango).hasToString("15 2 W");
    }
}