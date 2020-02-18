package edu.kit.informatik.RailwaySystem;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Point point) {
        return (this.x == point.getX()) && (this.y == point.getY());
    }

    public boolean isHorizontal(Point point) {
        return (this.y == point.getY());
    }

    public boolean isVertical(Point point) {
        return (this.x == point.getX());
    }

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow((point.getX() - this.x), 2) + Math.pow((point.getY() - this.y), 2));
    }

    @Override
    public String toString() {
        return ("(" + this.x + "," + this.y + ")");
    }

}
