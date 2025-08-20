package com.vwdigitalhub.tango.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Workspace {
    private final int width;
    private final int height;
    private final Set<Position> occupiedPositions = new HashSet<>();

    public Workspace(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isValidPosition(Position position) {
        // Check boundaries
        if (position.getX() < 0 || position.getX() > width || position.getY() < 0 || position.getY() > height) {
            return false;
        }
        // Check for collisions
        return !occupiedPositions.contains(position);
    }

    public void occupyPosition(Position position) {
        occupiedPositions.add(position);
    }

    public void freePosition(Position position) {
        occupiedPositions.remove(position);
    }
}
