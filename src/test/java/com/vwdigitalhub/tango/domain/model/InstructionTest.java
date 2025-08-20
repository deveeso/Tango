package com.vwdigitalhub.tango.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionTest {

    @Test
    @DisplayName("Should return L for character 'L'")
    void shouldReturnLForCharL() {
        assertThat(Instruction.fromChar('L')).isEqualTo(Instruction.L);
    }

    @Test
    @DisplayName("Should return R for character 'R'")
    void shouldReturnRForCharR() {
        assertThat(Instruction.fromChar('R')).isEqualTo(Instruction.R);
    }

    @Test
    @DisplayName("Should return M for character 'M'")
    void shouldReturnMForCharM() {
        assertThat(Instruction.fromChar('M')).isEqualTo(Instruction.M);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for an invalid character")
    void shouldThrowExceptionForInvalidChar() {
        // Given
        char invalidChar = 'X';
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            Instruction.fromChar(invalidChar);
        });
    }
}