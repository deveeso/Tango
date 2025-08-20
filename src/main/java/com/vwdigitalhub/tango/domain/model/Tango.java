package com.vwdigitalhub.tango.domain.model;

import java.util.LinkedList;
import java.util.Queue;

public class Tango {
    private final Workspace workspace;
    private Position position;
    private Orientation orientation;
    private Queue<Instruction> instructions = new LinkedList<>();


    public Tango(Position position, Orientation orientation, Workspace workspace) {
        this.position = position;
        this.orientation = orientation;
        this.workspace = workspace;
        changePosition(position); // Occupy the initial position in the workspace
    }

    public void executeInstructions() {
        while (!instructions.isEmpty()) {
            Instruction instruction = instructions.poll();
            executeInstruction(instruction);
        }
    }

    public void loadInstructions(String instructionString) {
        for (char c : instructionString.toCharArray()) {
            if (c == ' ') continue; // Ignore spaces
            instructions.add(Instruction.fromChar(c));
        }
    }

    private void changePosition(Position newPosition) {
        // Check if the new position is valid within the workspace, otherwise ignore the move
        if (workspace.isValidPosition(newPosition)) {
            // Update the positions in the workspace
            workspace.freePosition(this.position);
            workspace.occupyPosition(newPosition);
            this.position = newPosition;
        } else {
            throw new IllegalArgumentException("Invalid move to position: " + newPosition);
        }
    }

    private void executeInstruction(Instruction instruction) {
        switch (instruction) {
            case L -> orientation = orientation.turnLeft();
            case R -> orientation = orientation.turnRight();
            case M -> moveForward();
        }
    }

    private void moveForward() {
        Position newPosition = new Position(position.getX(), position.getY());
        newPosition.moveForward(orientation);
        changePosition(newPosition);
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation;
    }
}