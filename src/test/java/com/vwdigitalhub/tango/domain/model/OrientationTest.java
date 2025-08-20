package com.vwdigitalhub.tango.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class OrientationTest {

    @Nested
    class TurnRightTests {

        @Test
        @DisplayName("Should turn from North to East")
        void shouldTurnNorthToEast() {
            assertThat(Orientation.N.turnRight()).isEqualTo(Orientation.E);
        }

        @Test
        @DisplayName("Should turn from East to South")
        void shouldTurnEastToSouth() {
            assertThat(Orientation.E.turnRight()).isEqualTo(Orientation.S);
        }

        @Test
        @DisplayName("Should turn from South to West")
        void shouldTurnSouthToWest() {
            assertThat(Orientation.S.turnRight()).isEqualTo(Orientation.W);
        }

        @Test
        @DisplayName("Should turn from West to North")
        void shouldTurnWestToNorth() {
            assertThat(Orientation.W.turnRight()).isEqualTo(Orientation.N);
        }
    }

    @Nested
    class TurnLeftTests {
        @Test
        @DisplayName("Should turn from North to West")
        void shouldTurnNorthToWest() {
            assertThat(Orientation.N.turnLeft()).isEqualTo(Orientation.W);
        }

        @Test
        @DisplayName("Should turn from West to South")
        void shouldTurnWestToSouth() {
            assertThat(Orientation.W.turnLeft()).isEqualTo(Orientation.S);
        }

        @Test
        @DisplayName("Should turn from South to East")
        void shouldTurnSouthToEast() {
            assertThat(Orientation.S.turnLeft()).isEqualTo(Orientation.E);
        }

        @Test
        @DisplayName("Should turn from East to North")
        void shouldTurnEastToNorth() {
            assertThat(Orientation.E.turnLeft()).isEqualTo(Orientation.N);
        }
    }

    @Nested
    class FromCharTests {

        @Test
        @DisplayName("Should return N for character 'N'")
        void shouldReturnCorrectOrientationForValidChar() {
            assertThat(Orientation.fromChar('N')).isEqualTo(Orientation.N);
        }

        @Test
        @DisplayName("Should return S for character 'S'")
        void shouldReturnSForCharS() {
            assertThat(Orientation.fromChar('S')).isEqualTo(Orientation.S);
        }

        @Test
        @DisplayName("Should return E for character 'E'")
        void shouldReturnEForCharE() {
            assertThat(Orientation.fromChar('E')).isEqualTo(Orientation.E);
        }

        @Test
        @DisplayName("Should return W for character 'W'")
        void shouldReturnWForCharW() {
            assertThat(Orientation.fromChar('W')).isEqualTo(Orientation.W);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException for an invalid character")
        void shouldThrowExceptionForInvalidChar() {
            assertThrows(IllegalArgumentException.class, () -> {
                Orientation.fromChar('X');
            });
        }
    }
}
