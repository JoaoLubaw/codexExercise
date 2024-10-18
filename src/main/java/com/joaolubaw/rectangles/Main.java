package com.joaolubaw.rectangles;

import java.util.Scanner;

public class Main {
    private static final int GRID_SIZE = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read coordinates for rectangles
        Rectangle rectA = readRectangle(scanner, 'A');
        Rectangle rectB = readRectangle(scanner, 'B');
        Rectangle rectC = readRectangle(scanner, 'C');

        // Display the grid with rectangles
        printGrid(rectA, rectB, rectC);

        // Intersection and area information
        System.out.println("A = (" + rectA.getX1() + ", " + rectA.getY1() + "; " + rectA.getX2() + ", " + rectA.getY2() + ")");
        System.out.println("B = (" + rectB.getX1() + ", " + rectB.getY1() + "; " + rectB.getX2() + ", " + rectB.getY2() + ")");
        System.out.println("C = (" + rectC.getX1() + ", " + rectC.getY1() + "; " + rectC.getX2() + ", " + rectC.getY2() + ")");

        System.out.println("intersects(A, B) => " + rectA.intersects(rectB));
        System.out.println("intersects(A, C) => " + rectA.intersects(rectC));
        System.out.println("intersects(B, C) => " + rectB.intersects(rectC));

        System.out.println("areaOfIntersection(A, B) = " + rectA.intersectionArea(rectB));
        System.out.println("areaOfIntersection(A, C) = " + rectA.intersectionArea(rectC));
    }

    private static Rectangle readRectangle(Scanner scanner, char identifier) {
        int x1, y1, x2, y2;

        while (true) {
            System.out.println("Enter coordinates for Rectangle " + identifier);
            System.out.print("x1: ");
            x1 = scanner.nextInt();
            System.out.print("y1: ");
            y1 = scanner.nextInt();
            System.out.print("x2: ");
            x2 = scanner.nextInt();
            System.out.print("y2: ");
            y2 = scanner.nextInt();

            // Validate input to ensure coordinates are within the grid bounds
            if (x1 >= 0 && x1 < GRID_SIZE && x2 >= 0 && x2 < GRID_SIZE &&
                    y1 >= 0 && y1 < GRID_SIZE && y2 >= 0 && y2 < GRID_SIZE) {
                break; // Exit the loop if valid input
            } else {
                System.out.println("Coordinates must be between 0 and " + (GRID_SIZE - 1) + ". Please enter again.");
            }
        }

        return new Rectangle(x1, y1, x2, y2, identifier);
    }

    private static void printGrid(Rectangle... rectangles) {
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];

        // Fill the grid with '.'
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '.';
            }
        }

        // Fill the grid with rectangles
        for (Rectangle rect : rectangles) {
            for (int i = rect.getY1(); i <= rect.getY2(); i++) {
                for (int j = rect.getX1(); j <= rect.getX2(); j++) {
                    if (grid[i][j] == '.') {
                        grid[i][j] = rect.getIdentifier();
                    } else {
                        grid[i][j] = '#';  // Mark intersections
                    }
                }
            }
        }

        // Print numbered rows and the grid
        for (int i = GRID_SIZE - 1; i >= 0; i--) {
            System.out.printf("%2d ", i);  // Print row numbers
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        // Print column numbers
        System.out.print("   ");
        for (int j = 0; j < GRID_SIZE; j++) {
            if (j % 5 == 0) {
                System.out.printf("%-5d", j);
            }
        }
        System.out.println();
    }
}