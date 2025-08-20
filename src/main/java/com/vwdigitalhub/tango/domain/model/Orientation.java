package com.vwdigitalhub.tango.domain.model;

public enum Orientation {
    N, S, E, W;

    public Orientation turnLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    public Orientation turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public static Orientation fromChar(char c) {
        return switch (c) {
            case 'N' -> N;
            case 'S' -> S;
            case 'E' -> E;
            case 'W' -> W;
            default -> throw new IllegalArgumentException("Invalid orientation: " + c);
        };
    }
}
