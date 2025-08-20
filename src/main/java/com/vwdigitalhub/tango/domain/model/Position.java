package com.vwdigitalhub.tango.domain.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveForward(Orientation orientation) {
        switch (orientation) {
            case N -> y += 1;
            case E -> x += 1;
            case S -> y -= 1;
            case W -> x -= 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Methods needed for the workspace to manage occupied positions and remove them

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
