package com.vwdigitalhub.tango.domain.model;

public enum Instruction {
    L, R, M;

    public static Instruction fromChar(char c) {
        return switch (c) {
            case 'L' -> L;
            case 'R' -> R;
            case 'M' -> M;
            default -> throw new IllegalArgumentException("Invalid instruction: " + c);
        };
    }
}