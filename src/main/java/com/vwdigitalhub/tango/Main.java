package com.vwdigitalhub.tango;

import com.vwdigitalhub.tango.application.service.TangoService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce the workspace dimensions.");
            // Read workspace coordinates
            int workspaceX = scanner.nextInt();
            int workspaceY = scanner.nextInt();
            scanner.nextLine(); // Consume the rest of the line
            TangoService tangoService = new TangoService(workspaceX, workspaceY);
            System.out.println("Workspace dimensions loaded: " + workspaceX + " " + workspaceY + "\nIntroduce the robots starting positions and instructions.\n");

            // Read robots data and instructions until end of input
            while (scanner.hasNextLine()) {
                // Read robot starting position and orientation
                String positionLine = scanner.nextLine();
                if (positionLine.trim().isEmpty()) {
                    continue;
                }
                String[] positionParts = positionLine.split(" ");
                int startX = Integer.parseInt(positionParts[0]);
                int startY = Integer.parseInt(positionParts[1]);
                char startOrientation = positionParts[2].charAt(0);
                System.out.println("Robot starting position loaded: " + startX + " " + startY + " " + startOrientation);

                // Read instructions
                String instructions = scanner.nextLine();
                System.out.println("Robot instructions loaded: " + instructions);
                // Add the robot to the service
                tangoService.addRobot(startX, startY, startOrientation, instructions);
                System.out.println("Robot added\n");
            }

            // Execute all robot instructions sequentially
            List<String> finalPositions = tangoService.executeAllRobots();
            System.out.println("Robots cleaning instructions executed!");
            // Print the final output
            System.out.println("\nROBOTS CURRENT POSITIONS AND ORIENTATION:\n");
            for (String position : finalPositions) {
                System.out.println(position);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}