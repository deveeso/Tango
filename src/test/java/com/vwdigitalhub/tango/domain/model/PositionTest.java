package com.vwdigitalhub.tango.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    // Constructor and Getters
    @Test
    @DisplayName("Should initialize position with correct x and y coordinates")
    void shouldInitializeWithCorrectCoordinates() {
        Position position = new Position(5, 7);
        assertThat(position.getX()).isEqualTo(5);
        assertThat(position.getY()).isEqualTo(7);
    }

    // moveForward
    @Test
    @DisplayName("Should move forward correctly when orientation is North")
    void shouldMoveForwardNorth() {
        Position position = new Position(2, 2);
        position.moveForward(Orientation.N);
        assertThat(position.getX()).isEqualTo(2);
        assertThat(position.getY()).isEqualTo(3);
    }

    @Test
    @DisplayName("Should move forward correctly when orientation is East")
    void shouldMoveForwardEast() {
        Position position = new Position(2, 2);
        position.moveForward(Orientation.E);
        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(2);
    }

    @Test
    @DisplayName("Should move forward correctly when orientation is South")
    void shouldMoveForwardSouth() {
        Position position = new Position(2, 2);
        position.moveForward(Orientation.S);
        assertThat(position.getX()).isEqualTo(2);
        assertThat(position.getY()).isEqualTo(1);
    }

    @Test
    @DisplayName("Should move forward correctly when orientation is West")
    void shouldMoveForwardWest() {
        Position position = new Position(2, 2);
        position.moveForward(Orientation.W);
        assertThat(position.getX()).isEqualTo(1);
        assertThat(position.getY()).isEqualTo(2);
    }

    // equals() and hashCode()
    @Test
    @DisplayName("Two positions with the same coordinates should be equal")
    void shouldBeEqualIfCoordinatesAreSame() {
        Position position1 = new Position(5, 2);
        Position position2 = new Position(5, 2);
        assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("Two positions with different coordinates should not be equal")
    void shouldNotBeEqualIfCoordinatesAreDifferent() {
        Position position1 = new Position(3, 2);
        Position position2 = new Position(3, 3);
        assertThat(position1).isNotEqualTo(position2);
    }

    @Test
    @DisplayName("Should have the same hashCode for equal positions")
    void shouldHaveSameHashCodeForEqualPositions() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        assertThat(position1).hasSameHashCodeAs(position2.hashCode());
    }

    @Test
    @DisplayName("Should have different hashCodes for different positions")
    void shouldHaveDifferentHashCodeForDifferentPositions() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 5);
        assertThat(position1).doesNotHaveSameHashCodeAs(position2.hashCode());
    }
}