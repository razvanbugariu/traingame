package edu.kit.informatik.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch extends Track {
    private int id;
    private List<Point> points;
    private boolean endPoint1;
    private boolean endPoint2;

    public Switch(Point startPoint, Point endPoint1, Point endPoint2) throws IOException {
        if ((startPoint.isVertical(endPoint1) || ( startPoint.isHorizontal(endPoint1)) &&
                (startPoint.isVertical(endPoint2) || (startPoint.isHorizontal(endPoint2))))) {
            points = new ArrayList<>(Arrays.asList(startPoint, endPoint1, endPoint2));
            this.id = -1;
            this.endPoint1 = false;
            this.endPoint2 = false;

        } else {
            throw new IOException();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setSwitch(Point point) throws IOException {
        if (point.equals(points.get(1))) {
            endPoint1 = true;
        } else if (point.equals(points.get(2))) {
            endPoint2 = true;
        } else {
            throw new IOException();
        }
    }

    public int length() {
        if (endPoint1) {
            return (int) points.get(0).distanceTo(points.get(1));
        } else if (endPoint2) {
            return (int) points.get(0).distanceTo(points.get(2));
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String str = "";
        if (endPoint1 || endPoint2) {
            return ("s " + id + " " + points.get(0) + " -> " + points.get(1) + " " + length() + "\n");
        } else {
            return ("s " + id + " " + points.get(0) + " -> " + points.get(1) + "\n");
        }
     }
}
