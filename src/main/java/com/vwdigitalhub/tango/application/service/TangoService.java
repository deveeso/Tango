package com.vwdigitalhub.tango.application.service;

import com.vwdigitalhub.tango.domain.model.Orientation;
import com.vwdigitalhub.tango.domain.model.Position;
import com.vwdigitalhub.tango.domain.model.Tango;
import com.vwdigitalhub.tango.domain.model.Workspace;
import java.util.ArrayList;
import java.util.List;

public class TangoService {
    private final Workspace workspace;
    private final List<Tango> robots = new ArrayList<>();

    public TangoService(int workspaceX, int workspaceY) {
        this.workspace = new Workspace(workspaceX, workspaceY);
    }

    public void addRobot(int startX, int startY, char startOrientation, String instructions) {
        Position position = new Position(startX, startY);
        Orientation orientation = Orientation.fromChar(startOrientation);
        Tango robot = new Tango(position, orientation, workspace);
        robot.loadInstructions(instructions);
        robots.add(robot);
    }

    public List<String> executeAllRobots() {
        List<String> finalPositions = new ArrayList<>();
        for (Tango robot : robots) {
            robot.executeInstructions();
            finalPositions.add(robot.toString());
        }
        return finalPositions;
    }
}