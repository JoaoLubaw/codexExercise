package com.joaolubaw.rectangles;

public class Grid {
    private final char[][] grid;
    private final int width;
    private final int height;

    public Grid(Rectangle[] rectangles) {
        this.width = 50; // Define the width of the grid
        this.height = 50; // Define the height of the grid
        this.grid = new char[height][width];

        // Initialize the grid with dots '.'
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.';
            }
        }

        // Fill the grid with rectangles
        for (Rectangle rect : rectangles) {
            fillRectangle(rect);
        }
    }

    // Fill the grid with the rectangle character or mark intersections
    private void fillRectangle(Rectangle rect) {
        for (int i = rect.getY1(); i <= rect.getY2(); i++) {
            for (int j = rect.getX1(); j <= rect.getX2(); j++) {
                // If there's already a rectangle in the position, mark it as intersection '#'
                if (grid[i][j] == '.') {
                    grid[i][j] = rect.getIdentifier();
                } else {
                    grid[i][j] = '#';
                }
            }
        }
    }

    // Display the grid
    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
