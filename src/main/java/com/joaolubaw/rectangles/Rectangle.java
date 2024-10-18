package com.joaolubaw.rectangles;


class Rectangle {
    private int x1, y1, x2, y2;
    private char identifier;

    public Rectangle(int x1, int y1, int x2, int y2, char identifier) {
        // Correct the order of the points
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
        this.identifier = identifier;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public char getIdentifier() { return identifier; }

    // Check if this rectangle intersects with another rectangle
    public boolean intersects(Rectangle other) {
        return this.x1 <= other.x2 && this.x2 >= other.x1 &&
                this.y1 <= other.y2 && this.y2 >= other.y1;
    }

    // Calculate the area of intersection with another rectangle
    public int intersectionArea(Rectangle other) {
        if (!intersects(other)) return 0;

        int xOverlap = Math.max(0, Math.min(this.x2, other.x2) - Math.max(this.x1, other.x1) + 1);
        int yOverlap = Math.max(0, Math.min(this.y2, other.y2) - Math.max(this.y1, other.y1) + 1);

        return xOverlap * yOverlap;
    }
}